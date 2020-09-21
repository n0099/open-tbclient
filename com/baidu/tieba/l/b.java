package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.k.e;
import java.io.File;
/* loaded from: classes22.dex */
public class b implements e {
    private String kqM;
    private boolean kqN = false;
    private boolean kqO = false;
    private e.a kqP;

    public b(String str) {
        this.kqM = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.kqP = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cUI() {
        if (StringUtils.isNull(this.kqM)) {
            if (this.kqP != null) {
                this.kqP.DE(2);
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
                    int Nn = a.Nn(str);
                    publishProgress(new c(1, Nn));
                    if (Nn == 1) {
                        boolean fy = a.fy(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, fy ? 1 : 0);
                        publishProgress(cVarArr);
                        if (fy) {
                            boolean fz = b.fz(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, fz ? 1 : 0);
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
                        if (b.this.kqP != null) {
                            b.this.kqP.DE(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.kqP != null) {
                            b.this.kqP.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.kqP != null) {
                        b.this.kqP.sd(cVar.value == 1);
                    }
                }
            }
        }.execute(this.kqM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fz(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
