package com.baidu.tieba.l;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.k.e;
import com.baidu.tieba.l.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes10.dex */
public class b implements e {
    private String jKk;
    private boolean jKl = false;
    private boolean jKm = false;
    private e.a jKn;

    public b(String str) {
        this.jKk = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.jKn = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cCp() {
        if (f.bcM()) {
            if (StringUtils.isNull(this.jKk) || !QuickVideoView.xP(this.jKk)) {
                if (this.jKn != null) {
                    this.jKn.Al(2);
                    return;
                }
                return;
            }
            a.a(this.jKk, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void n(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.jKl = true;
                        b.this.cCW();
                    }
                    if (b.this.jKn != null) {
                        b.this.jKn.Al(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCW() {
        if (f.bcM()) {
            if (StringUtils.isNull(this.jKk) || !QuickVideoView.xP(this.jKk)) {
                if (this.jKn != null) {
                    this.jKn.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.jKk, this.jKk + "_moov_head_suffix", new a.InterfaceC0667a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0667a
                public void qJ(boolean z) {
                    if (b.this.jKl && z) {
                        b.this.jKm = true;
                    }
                    if (b.this.jKn != null) {
                        b.this.jKn.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cCq() {
        if (f.bcM()) {
            if (StringUtils.isNull(this.jKk) || !new File(this.jKk).exists() || !new File(this.jKk + "_moov_head_suffix").exists() || !this.jKl || !this.jKm) {
                if (this.jKn != null) {
                    this.jKn.qG(false);
                    return;
                }
                return;
            }
            new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.l.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                        return Boolean.valueOf(b.eS(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.jKn != null) {
                        b.this.jKn.qG(bool.booleanValue());
                    }
                }
            }.execute(this.jKk);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cCr() {
        if (StringUtils.isNull(this.jKk) || !QuickVideoView.xP(this.jKk)) {
            if (this.jKn != null) {
                this.jKn.Al(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.l.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int Jg = a.Jg(str);
                    publishProgress(new c(1, Jg));
                    if (Jg == 1) {
                        boolean eR = a.eR(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, eR ? 1 : 0);
                        publishProgress(cVarArr);
                        if (eR) {
                            boolean eS = b.eS(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, eS ? 1 : 0);
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
                        if (b.this.jKn != null) {
                            b.this.jKn.Al(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.jKn != null) {
                            b.this.jKn.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.jKn != null) {
                        b.this.jKn.qG(cVar.value == 1);
                    }
                }
            }
        }.execute(this.jKk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eS(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
