package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.k.e;
import java.io.File;
/* loaded from: classes23.dex */
public class b implements e {
    private String kFY;
    private boolean kFZ = false;
    private boolean kGa = false;
    private e.a kGb;

    public b(String str) {
        this.kFY = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.kGb = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cYr() {
        if (StringUtils.isNull(this.kFY)) {
            if (this.kGb != null) {
                this.kGb.Ek(2);
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
                    int Oc = a.Oc(str);
                    publishProgress(new c(1, Oc));
                    if (Oc == 1) {
                        boolean fF = a.fF(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, fF ? 1 : 0);
                        publishProgress(cVarArr);
                        if (fF) {
                            boolean fG = b.fG(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, fG ? 1 : 0);
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
                        if (b.this.kGb != null) {
                            b.this.kGb.Ek(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.kGb != null) {
                            b.this.kGb.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.kGb != null) {
                        b.this.kGb.sK(cVar.value == 1);
                    }
                }
            }
        }.execute(this.kFY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fG(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
