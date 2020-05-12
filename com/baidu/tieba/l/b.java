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
    private String jcK;
    private boolean jcL = false;
    private boolean jcM = false;
    private e.a jcN;

    public b(String str) {
        this.jcK = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.jcN = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void crx() {
        if (f.aUz()) {
            if (StringUtils.isNull(this.jcK) || !QuickVideoView.vQ(this.jcK)) {
                if (this.jcN != null) {
                    this.jcN.yP(2);
                    return;
                }
                return;
            }
            a.a(this.jcK, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.jcL = true;
                        b.this.cse();
                    }
                    if (b.this.jcN != null) {
                        b.this.jcN.yP(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cse() {
        if (f.aUz()) {
            if (StringUtils.isNull(this.jcK) || !QuickVideoView.vQ(this.jcK)) {
                if (this.jcN != null) {
                    this.jcN.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.jcK, this.jcK + "_moov_head_suffix", new a.InterfaceC0604a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0604a
                public void qc(boolean z) {
                    if (b.this.jcL && z) {
                        b.this.jcM = true;
                    }
                    if (b.this.jcN != null) {
                        b.this.jcN.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cry() {
        if (f.aUz()) {
            if (StringUtils.isNull(this.jcK) || !new File(this.jcK).exists() || !new File(this.jcK + "_moov_head_suffix").exists() || !this.jcL || !this.jcM) {
                if (this.jcN != null) {
                    this.jcN.pZ(false);
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
                        return Boolean.valueOf(b.el(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.jcN != null) {
                        b.this.jcN.pZ(bool.booleanValue());
                    }
                }
            }.execute(this.jcK);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void crz() {
        if (StringUtils.isNull(this.jcK) || !QuickVideoView.vQ(this.jcK)) {
            if (this.jcN != null) {
                this.jcN.yP(2);
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
                    int GU = a.GU(str);
                    publishProgress(new c(1, GU));
                    if (GU == 1) {
                        boolean ek = a.ek(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, ek ? 1 : 0);
                        publishProgress(cVarArr);
                        if (ek) {
                            boolean el = b.el(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, el ? 1 : 0);
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
                        if (b.this.jcN != null) {
                            b.this.jcN.yP(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.jcN != null) {
                            b.this.jcN.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.jcN != null) {
                        b.this.jcN.pZ(cVar.value == 1);
                    }
                }
            }
        }.execute(this.jcK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean el(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
