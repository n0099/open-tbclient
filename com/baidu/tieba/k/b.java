package com.baidu.tieba.k;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.j.e;
import com.baidu.tieba.k.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes7.dex */
public class b implements e {
    private String ilm;
    private boolean iln = false;
    private boolean ilo = false;
    private e.a ilp;

    public b(String str) {
        this.ilm = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.ilp = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void cdI() {
        if (f.aJj()) {
            if (StringUtils.isNull(this.ilm) || !QuickVideoView.uc(this.ilm)) {
                if (this.ilp != null) {
                    this.ilp.xV(2);
                    return;
                }
                return;
            }
            a.a(this.ilm, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.iln = true;
                        b.this.ceo();
                    }
                    if (b.this.ilp != null) {
                        b.this.ilp.xV(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceo() {
        if (f.aJj()) {
            if (StringUtils.isNull(this.ilm) || !QuickVideoView.uc(this.ilm)) {
                if (this.ilp != null) {
                    this.ilp.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.ilm, this.ilm + "_moov_head_suffix", new a.InterfaceC0533a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0533a
                public void oD(boolean z) {
                    if (b.this.iln && z) {
                        b.this.ilo = true;
                    }
                    if (b.this.ilp != null) {
                        b.this.ilp.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void cdJ() {
        if (f.aJj()) {
            if (StringUtils.isNull(this.ilm) || !new File(this.ilm).exists() || !new File(this.ilm + "_moov_head_suffix").exists() || !this.iln || !this.ilo) {
                if (this.ilp != null) {
                    this.ilp.oA(false);
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
                        return Boolean.valueOf(b.dN(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.ilp != null) {
                        b.this.ilp.oA(bool.booleanValue());
                    }
                }
            }.execute(this.ilm);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void cdK() {
        if (StringUtils.isNull(this.ilm) || !QuickVideoView.uc(this.ilm)) {
            if (this.ilp != null) {
                this.ilp.xV(2);
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
                    int EK = a.EK(str);
                    publishProgress(new c(1, EK));
                    if (EK == 1) {
                        boolean dM = a.dM(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dM ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dM) {
                            boolean dN = b.dN(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, dN ? 1 : 0);
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
                        if (b.this.ilp != null) {
                            b.this.ilp.xV(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.ilp != null) {
                            b.this.ilp.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.ilp != null) {
                        b.this.ilp.oA(cVar.value == 1);
                    }
                }
            }
        }.execute(this.ilm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dN(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
