package com.baidu.tieba.k;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.j.e;
import com.baidu.tieba.k.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes5.dex */
public class b implements e {
    private boolean hzp = false;
    private boolean hzq = false;
    private e.a hzr;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.hzr = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void bPy() {
        if (f.apS()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.pO(this.mLocalPath)) {
                if (this.hzr != null) {
                    this.hzr.xp(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void j(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.hzp = true;
                        b.this.bQe();
                    }
                    if (b.this.hzr != null) {
                        b.this.hzr.xp(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQe() {
        if (f.apS()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.pO(this.mLocalPath)) {
                if (this.hzr != null) {
                    this.hzr.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0363a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0363a
                public void nC(boolean z) {
                    if (b.this.hzp && z) {
                        b.this.hzq = true;
                    }
                    if (b.this.hzr != null) {
                        b.this.hzr.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bPz() {
        if (f.apS()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.hzp || !this.hzq) {
                if (this.hzr != null) {
                    this.hzr.nz(false);
                    return;
                }
                return;
            }
            new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.k.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                        return Boolean.valueOf(b.dI(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.hzr != null) {
                        b.this.hzr.nz(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bPA() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.pO(this.mLocalPath)) {
            if (this.hzr != null) {
                this.hzr.xp(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.k.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int BI = a.BI(str);
                    publishProgress(new c(1, BI));
                    if (BI == 1) {
                        boolean dH = a.dH(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dH ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dH) {
                            boolean dI = b.dI(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, dI ? 1 : 0);
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
                        if (b.this.hzr != null) {
                            b.this.hzr.xp(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.hzr != null) {
                            b.this.hzr.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.hzr != null) {
                        b.this.hzr.nz(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dI(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
