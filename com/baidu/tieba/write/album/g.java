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
    final /* synthetic */ e ctT;
    private final aq ctU;
    private final String ctV;
    private String ctW;
    private List<a> ctX;

    public g(e eVar, String str, aq aqVar) {
        this.ctT = eVar;
        this.ctU = aqVar;
        this.ctV = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public List<ImageFileInfo> doInBackground(Void... voidArr) {
        List<a> apW;
        List<ImageFileInfo> jd;
        if (TextUtils.isEmpty(this.ctV)) {
            return null;
        }
        if (!this.ctV.equals("-1")) {
            return jd(this.ctV);
        }
        ArrayList arrayList = new ArrayList();
        apW = this.ctT.apW();
        this.ctX = apW;
        if (this.ctX != null) {
            for (a aVar : this.ctX) {
                String albumId = aVar.getAlbumId();
                if (!TextUtils.isEmpty(albumId) && (jd = jd(albumId)) != null && jd.size() > 0) {
                    arrayList.addAll(jd);
                }
            }
        }
        return arrayList;
    }

    private List<ImageFileInfo> jd(String str) {
        Context context;
        Context context2;
        context = this.ctT.mContext;
        List<ImageFileInfo> a = a(str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (a == null || a.size() <= 0) {
            context2 = this.ctT.mContext;
            return a(str, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.ctU != null) {
            this.ctU.mU();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.ctU != null) {
            this.ctU.a(this.ctX, list, this.ctW);
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
                this.ctW = cursor.getString(columnIndex2);
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
