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
    private String hyc;
    private boolean hyd = false;
    private boolean hye = false;
    private e.a hyf;

    public b(String str) {
        this.hyc = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.hyf = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void bMy() {
        if (f.arM()) {
            if (StringUtils.isNull(this.hyc) || !QuickVideoView.oY(this.hyc)) {
                if (this.hyf != null) {
                    this.hyf.vV(2);
                    return;
                }
                return;
            }
            a.a(this.hyc, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void g(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.hyd = true;
                        b.this.bNe();
                    }
                    if (b.this.hyf != null) {
                        b.this.hyf.vV(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNe() {
        if (f.arM()) {
            if (StringUtils.isNull(this.hyc) || !QuickVideoView.oY(this.hyc)) {
                if (this.hyf != null) {
                    this.hyf.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.hyc, this.hyc + "_moov_head_suffix", new a.InterfaceC0452a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0452a
                public void no(boolean z) {
                    if (b.this.hyd && z) {
                        b.this.hye = true;
                    }
                    if (b.this.hyf != null) {
                        b.this.hyf.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bMz() {
        if (f.arM()) {
            if (StringUtils.isNull(this.hyc) || !new File(this.hyc).exists() || !new File(this.hyc + "_moov_head_suffix").exists() || !this.hyd || !this.hye) {
                if (this.hyf != null) {
                    this.hyf.nl(false);
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
                        return Boolean.valueOf(b.du(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.hyf != null) {
                        b.this.hyf.nl(bool.booleanValue());
                    }
                }
            }.execute(this.hyc);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bMA() {
        if (StringUtils.isNull(this.hyc) || !QuickVideoView.oY(this.hyc)) {
            if (this.hyf != null) {
                this.hyf.vV(2);
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
                    int Ac = a.Ac(str);
                    publishProgress(new c(1, Ac));
                    if (Ac == 1) {
                        boolean dt = a.dt(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dt ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dt) {
                            boolean du = b.du(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, du ? 1 : 0);
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
                        if (b.this.hyf != null) {
                            b.this.hyf.vV(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.hyf != null) {
                            b.this.hyf.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.hyf != null) {
                        b.this.hyf.nl(cVar.value == 1);
                    }
                }
            }
        }.execute(this.hyc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean du(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
