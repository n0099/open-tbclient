package com.baidu.tieba.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.l.e;
import java.io.File;
/* loaded from: classes23.dex */
public class b implements e {
    private String lmc;
    private boolean lmd = false;
    private boolean lme = false;
    private e.a lmf;

    public b(String str) {
        this.lmc = str;
    }

    @Override // com.baidu.tieba.l.e
    public void a(e.a aVar) {
        this.lmf = aVar;
    }

    @Override // com.baidu.tieba.l.e
    public void diJ() {
        if (StringUtils.isNull(this.lmc)) {
            if (this.lmf != null) {
                this.lmf.Gd(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.m.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int Pu = a.Pu(str);
                    publishProgress(new c(1, Pu));
                    if (Pu == 1) {
                        boolean fP = a.fP(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, fP ? 1 : 0);
                        publishProgress(cVarArr);
                        if (fP) {
                            boolean fQ = b.fQ(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, fQ ? 1 : 0);
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
                        if (b.this.lmf != null) {
                            b.this.lmf.Gd(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.lmf != null) {
                            b.this.lmf.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.lmf != null) {
                        b.this.lmf.tP(cVar.value == 1);
                    }
                }
            }
        }.execute(this.lmc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fQ(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
