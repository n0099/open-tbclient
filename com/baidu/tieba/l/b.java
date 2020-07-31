package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.k.e;
import java.io.File;
/* loaded from: classes17.dex */
public class b implements e {
    private String jSI;
    private boolean jSJ = false;
    private boolean jSK = false;
    private e.a jSL;

    public b(String str) {
        this.jSI = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.jSL = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cGm() {
        if (StringUtils.isNull(this.jSI)) {
            if (this.jSL != null) {
                this.jSL.AK(2);
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
                    int JS = a.JS(str);
                    publishProgress(new c(1, JS));
                    if (JS == 1) {
                        boolean eT = a.eT(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, eT ? 1 : 0);
                        publishProgress(cVarArr);
                        if (eT) {
                            boolean eU = b.eU(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, eU ? 1 : 0);
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
                        if (b.this.jSL != null) {
                            b.this.jSL.AK(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.jSL != null) {
                            b.this.jSL.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.jSL != null) {
                        b.this.jSL.rn(cVar.value == 1);
                    }
                }
            }
        }.execute(this.jSI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eU(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
