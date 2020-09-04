package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.k.e;
import java.io.File;
/* loaded from: classes17.dex */
public class b implements e {
    private String kin;
    private boolean kio = false;
    private boolean kip = false;
    private e.a kiq;

    public b(String str) {
        this.kin = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.kiq = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cRc() {
        if (StringUtils.isNull(this.kin)) {
            if (this.kiq != null) {
                this.kiq.Dd(2);
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
                    int ML = a.ML(str);
                    publishProgress(new c(1, ML));
                    if (ML == 1) {
                        boolean fl = a.fl(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, fl ? 1 : 0);
                        publishProgress(cVarArr);
                        if (fl) {
                            boolean fm = b.fm(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, fm ? 1 : 0);
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
                        if (b.this.kiq != null) {
                            b.this.kiq.Dd(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.kiq != null) {
                            b.this.kiq.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.kiq != null) {
                        b.this.kiq.rV(cVar.value == 1);
                    }
                }
            }
        }.execute(this.kin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fm(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
