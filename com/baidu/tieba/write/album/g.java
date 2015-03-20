package com.baidu.tieba.write.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, Integer, List<ImageFileInfo>> {
    final /* synthetic */ e ctD;
    private final aq ctE;
    private final String ctF;
    private String ctG;
    private List<a> ctH;

    public g(e eVar, String str, aq aqVar) {
        this.ctD = eVar;
        this.ctE = aqVar;
        this.ctF = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public List<ImageFileInfo> doInBackground(Void... voidArr) {
        List<a> apH;
        List<ImageFileInfo> ja;
        if (TextUtils.isEmpty(this.ctF)) {
            return null;
        }
        if (!this.ctF.equals("-1")) {
            return ja(this.ctF);
        }
        ArrayList arrayList = new ArrayList();
        apH = this.ctD.apH();
        this.ctH = apH;
        if (this.ctH != null) {
            for (a aVar : this.ctH) {
                String albumId = aVar.getAlbumId();
                if (!TextUtils.isEmpty(albumId) && (ja = ja(albumId)) != null && ja.size() > 0) {
                    arrayList.addAll(ja);
                }
            }
        }
        return arrayList;
    }

    private List<ImageFileInfo> ja(String str) {
        Context context;
        Context context2;
        context = this.ctD.mContext;
        List<ImageFileInfo> a = a(str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (a == null || a.size() <= 0) {
            context2 = this.ctD.mContext;
            return a(str, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.ctE != null) {
            this.ctE.mU();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.ctE != null) {
            this.ctE.a(this.ctH, list, this.ctG);
        }
    }

    private List<ImageFileInfo> a(String str, Context context, Uri uri) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
            try {
                try {
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.b(cursor);
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.b(cursor);
            throw th;
        }
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("_data");
            int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
            do {
                String string = cursor.getString(columnIndex);
                this.ctG = cursor.getString(columnIndex2);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setAlbumnId(str);
                imageFileInfo.setFilePath(string);
                if (new File(string).exists()) {
                    arrayList.add(imageFileInfo);
                }
            } while (cursor.moveToNext());
            com.baidu.adp.lib.g.a.b(cursor);
            return arrayList;
        }
        com.baidu.adp.lib.g.a.b(cursor);
        return arrayList;
    }
}
