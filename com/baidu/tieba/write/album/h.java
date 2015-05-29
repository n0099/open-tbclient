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
public class h extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
    final /* synthetic */ e cyi;
    private final as cyj;
    private final String cyk;
    private String cyl;
    private List<a> cym;
    private int cyn = 1;
    private g cyo = new i(this);

    public h(e eVar, String str, as asVar) {
        this.cyi = eVar;
        this.cyj = asVar;
        this.cyk = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public List<ImageFileInfo> doInBackground(Void... voidArr) {
        List<a> arM;
        if (TextUtils.isEmpty(this.cyk)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.cyk.equals("-1")) {
            arM = this.cyi.arM();
            this.cym = arM;
            if (this.cym != null) {
                for (a aVar : this.cym) {
                    String albumId = aVar.getAlbumId();
                    if (!TextUtils.isEmpty(albumId)) {
                        a(arrayList, this.cyo, albumId);
                    }
                }
            }
            return arrayList;
        }
        a(arrayList, this.cyo, this.cyk);
        return arrayList;
    }

    private void a(List<ImageFileInfo> list, g gVar, String str) {
        Context context;
        Context context2;
        if (list != null) {
            context = this.cyi.mContext;
            a(list, gVar, str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (list == null || list.size() <= 0) {
                context2 = this.cyi.mContext;
                a(list, gVar, str, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.cyj != null) {
            this.cyj.nm();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(List<ImageFileInfo>... listArr) {
        super.onProgressUpdate(listArr);
        if (listArr.length > 0 && this.cyj != null) {
            this.cyj.a(this.cym, listArr[0], this.cyl);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.cyj != null) {
            this.cyj.a(this.cym, list, this.cyl);
        }
    }

    private void a(List<ImageFileInfo> list, g gVar) {
        if (list != null && gVar != null) {
            if (this.cyn == 1 || this.cyn == 2) {
                if (list.size() / this.cyn > 50) {
                    if (gVar != null) {
                        gVar.bc(list);
                    }
                    this.cyn++;
                }
            } else if (list.size() / this.cyn > 500) {
                if (gVar != null) {
                    gVar.bc(list);
                }
                this.cyn++;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0082 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    private void a(List<ImageFileInfo> list, g gVar, String str, Context context, Uri uri) {
        Cursor cursor;
        if (list != null) {
            ?? r1 = "bucket_display_name";
            try {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                    try {
                        if (cursor.moveToFirst()) {
                            int columnIndex = cursor.getColumnIndex("_data");
                            int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                            do {
                                String string = cursor.getString(columnIndex);
                                this.cyl = cursor.getString(columnIndex2);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(str);
                                imageFileInfo.setFilePath(string);
                                File file = new File(string);
                                if (file.exists() && file.length() > 0) {
                                    list.add(imageFileInfo);
                                    a(list, gVar);
                                }
                            } while (cursor.moveToNext());
                            com.baidu.adp.lib.g.a.b(cursor);
                        }
                        com.baidu.adp.lib.g.a.b(cursor);
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        com.baidu.adp.lib.g.a.b(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.g.a.b((Cursor) r1);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                com.baidu.adp.lib.g.a.b((Cursor) r1);
                throw th;
            }
        }
    }
}
