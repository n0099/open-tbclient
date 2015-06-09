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
    final /* synthetic */ e cyj;
    private final as cyk;
    private final String cyl;
    private String cym;
    private List<a> cyn;
    private int cyo = 1;
    private g cyp = new i(this);

    public h(e eVar, String str, as asVar) {
        this.cyj = eVar;
        this.cyk = asVar;
        this.cyl = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public List<ImageFileInfo> doInBackground(Void... voidArr) {
        List<a> arN;
        if (TextUtils.isEmpty(this.cyl)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.cyl.equals("-1")) {
            arN = this.cyj.arN();
            this.cyn = arN;
            if (this.cyn != null) {
                for (a aVar : this.cyn) {
                    String albumId = aVar.getAlbumId();
                    if (!TextUtils.isEmpty(albumId)) {
                        a(arrayList, this.cyp, albumId);
                    }
                }
            }
            return arrayList;
        }
        a(arrayList, this.cyp, this.cyl);
        return arrayList;
    }

    private void a(List<ImageFileInfo> list, g gVar, String str) {
        Context context;
        Context context2;
        if (list != null) {
            context = this.cyj.mContext;
            a(list, gVar, str, context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (list == null || list.size() <= 0) {
                context2 = this.cyj.mContext;
                a(list, gVar, str, context2, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        if (this.cyk != null) {
            this.cyk.nm();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(List<ImageFileInfo>... listArr) {
        super.onProgressUpdate(listArr);
        if (listArr.length > 0 && this.cyk != null) {
            this.cyk.a(this.cyn, listArr[0], this.cym);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<ImageFileInfo> list) {
        super.onPostExecute(list);
        if (this.cyk != null) {
            this.cyk.a(this.cyn, list, this.cym);
        }
    }

    private void a(List<ImageFileInfo> list, g gVar) {
        if (list != null && gVar != null) {
            if (this.cyo == 1 || this.cyo == 2) {
                if (list.size() / this.cyo > 50) {
                    if (gVar != null) {
                        gVar.bc(list);
                    }
                    this.cyo++;
                }
            } else if (list.size() / this.cyo > 500) {
                if (gVar != null) {
                    gVar.bc(list);
                }
                this.cyo++;
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
                                this.cym = cursor.getString(columnIndex2);
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
