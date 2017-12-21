package com.baidu.tieba.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.i.e;
import com.baidu.tieba.j.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes2.dex */
public class b implements e {
    private boolean eFn = false;
    private boolean eFo = false;
    private e.a eFp;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.i.e
    public void a(e.a aVar) {
        this.eFp = aVar;
    }

    @Override // com.baidu.tieba.i.e
    public void aNP() {
        if (f.AF()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rp(this.mLocalPath)) {
                if (this.eFp != null) {
                    this.eFp.ps(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.j.b.1
                @Override // com.baidu.tieba.j.a.b
                public void pv(int i) {
                    if (i == 1) {
                        b.this.eFn = true;
                        b.this.aOq();
                    }
                    if (b.this.eFp != null) {
                        b.this.eFp.ps(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOq() {
        if (f.AF()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rp(this.mLocalPath)) {
                if (this.eFp != null) {
                    this.eFp.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0117a() { // from class: com.baidu.tieba.j.b.2
                @Override // com.baidu.tieba.j.a.InterfaceC0117a
                public void iu(boolean z) {
                    if (b.this.eFn && z) {
                        b.this.eFo = true;
                    }
                    if (b.this.eFp != null) {
                        b.this.eFp.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aNQ() {
        if (f.AF()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.eFn || !this.eFo) {
                if (this.eFp != null) {
                    this.eFp.it(false);
                    return;
                }
                return;
            }
            new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.j.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                        return Boolean.valueOf(b.bD(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.eFp != null) {
                        b.this.eFp.it(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aNR() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rp(this.mLocalPath)) {
            if (this.eFp != null) {
                this.eFp.ps(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.j.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int pg = a.pg(str);
                    publishProgress(new c(1, pg));
                    if (pg == 1) {
                        boolean bC = a.bC(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, bC ? 1 : 0);
                        publishProgress(cVarArr);
                        if (bC) {
                            boolean bD = b.bD(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, bD ? 1 : 0);
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
                        if (b.this.eFp != null) {
                            b.this.eFp.ps(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.eFp != null) {
                            b.this.eFp.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.eFp != null) {
                        b.this.eFp.it(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bD(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
