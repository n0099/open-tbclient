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
    private String hxl;
    private boolean hxm = false;
    private boolean hxn = false;
    private e.a hxo;

    public b(String str) {
        this.hxl = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.hxo = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void bMw() {
        if (f.arK()) {
            if (StringUtils.isNull(this.hxl) || !QuickVideoView.oY(this.hxl)) {
                if (this.hxo != null) {
                    this.hxo.vU(2);
                    return;
                }
                return;
            }
            a.a(this.hxl, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void g(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.hxm = true;
                        b.this.bNc();
                    }
                    if (b.this.hxo != null) {
                        b.this.hxo.vU(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNc() {
        if (f.arK()) {
            if (StringUtils.isNull(this.hxl) || !QuickVideoView.oY(this.hxl)) {
                if (this.hxo != null) {
                    this.hxo.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.hxl, this.hxl + "_moov_head_suffix", new a.InterfaceC0452a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0452a
                public void no(boolean z) {
                    if (b.this.hxm && z) {
                        b.this.hxn = true;
                    }
                    if (b.this.hxo != null) {
                        b.this.hxo.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bMx() {
        if (f.arK()) {
            if (StringUtils.isNull(this.hxl) || !new File(this.hxl).exists() || !new File(this.hxl + "_moov_head_suffix").exists() || !this.hxm || !this.hxn) {
                if (this.hxo != null) {
                    this.hxo.nl(false);
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
                    if (b.this.hxo != null) {
                        b.this.hxo.nl(bool.booleanValue());
                    }
                }
            }.execute(this.hxl);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bMy() {
        if (StringUtils.isNull(this.hxl) || !QuickVideoView.oY(this.hxl)) {
            if (this.hxo != null) {
                this.hxo.vU(2);
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
                        if (b.this.hxo != null) {
                            b.this.hxo.vU(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.hxo != null) {
                            b.this.hxo.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.hxo != null) {
                        b.this.hxo.nl(cVar.value == 1);
                    }
                }
            }
        }.execute(this.hxl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean du(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
