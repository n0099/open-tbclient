package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.k.e;
import java.io.File;
/* loaded from: classes23.dex */
public class b implements e {
    private String kSv;
    private boolean kSw = false;
    private boolean kSx = false;
    private e.a kSy;

    public b(String str) {
        this.kSv = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.kSy = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void dbz() {
        if (StringUtils.isNull(this.kSv)) {
            if (this.kSy != null) {
                this.kSy.ED(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.l.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int OA = a.OA(str);
                    publishProgress(new c(1, OA));
                    if (OA == 1) {
                        boolean fK = a.fK(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, fK ? 1 : 0);
                        publishProgress(cVarArr);
                        if (fK) {
                            boolean fL = b.fL(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, fL ? 1 : 0);
                            publishProgress(cVarArr2);
                        }
                    }
                }
                return null;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public void onProgressUpdate(c... cVarArr) {
                super.onProgressUpdate(cVarArr);
                if (cVarArr != null && cVarArr.length == 1 && cVarArr[0] != null) {
                    c cVar = cVarArr[0];
                    if (cVar.type == 1) {
                        if (b.this.kSy != null) {
                            b.this.kSy.ED(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.kSy != null) {
                            b.this.kSy.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.kSy != null) {
                        b.this.kSy.tb(cVar.value == 1);
                    }
                }
            }
        }.execute(this.kSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fL(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
