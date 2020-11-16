package com.baidu.tieba.m;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.l.e;
import java.io.File;
/* loaded from: classes22.dex */
public class b implements e {
    private String kYJ;
    private boolean kYK = false;
    private boolean kYL = false;
    private e.a kYM;

    public b(String str) {
        this.kYJ = str;
    }

    @Override // com.baidu.tieba.l.e
    public void a(e.a aVar) {
        this.kYM = aVar;
    }

    @Override // com.baidu.tieba.l.e
    public void ddy() {
        if (StringUtils.isNull(this.kYJ)) {
            if (this.kYM != null) {
                this.kYM.Fo(2);
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
                    int On = a.On(str);
                    publishProgress(new c(1, On));
                    if (On == 1) {
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
                        if (b.this.kYM != null) {
                            b.this.kYM.Fo(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.kYM != null) {
                            b.this.kYM.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.kYM != null) {
                        b.this.kYM.tn(cVar.value == 1);
                    }
                }
            }
        }.execute(this.kYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fL(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
