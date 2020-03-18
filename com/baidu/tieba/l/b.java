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
    private String isB;
    private boolean isC = false;
    private boolean isD = false;
    private e.a isE;

    public b(String str) {
        this.isB = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.isE = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cgS() {
        if (f.aMe()) {
            if (StringUtils.isNull(this.isB) || !QuickVideoView.uy(this.isB)) {
                if (this.isE != null) {
                    this.isE.yo(2);
                    return;
                }
                return;
            }
            a.a(this.isB, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.isC = true;
                        b.this.chz();
                    }
                    if (b.this.isE != null) {
                        b.this.isE.yo(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chz() {
        if (f.aMe()) {
            if (StringUtils.isNull(this.isB) || !QuickVideoView.uy(this.isB)) {
                if (this.isE != null) {
                    this.isE.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.isB, this.isB + "_moov_head_suffix", new a.InterfaceC0546a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0546a
                public void oY(boolean z) {
                    if (b.this.isC && z) {
                        b.this.isD = true;
                    }
                    if (b.this.isE != null) {
                        b.this.isE.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgT() {
        if (f.aMe()) {
            if (StringUtils.isNull(this.isB) || !new File(this.isB).exists() || !new File(this.isB + "_moov_head_suffix").exists() || !this.isC || !this.isD) {
                if (this.isE != null) {
                    this.isE.oV(false);
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
                        return Boolean.valueOf(b.dW(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.isE != null) {
                        b.this.isE.oV(bool.booleanValue());
                    }
                }
            }.execute(this.isB);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgU() {
        if (StringUtils.isNull(this.isB) || !QuickVideoView.uy(this.isB)) {
            if (this.isE != null) {
                this.isE.yo(2);
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
                    int Fj = a.Fj(str);
                    publishProgress(new c(1, Fj));
                    if (Fj == 1) {
                        boolean dV = a.dV(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dV ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dV) {
                            boolean dW = b.dW(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, dW ? 1 : 0);
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
                        if (b.this.isE != null) {
                            b.this.isE.yo(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.isE != null) {
                            b.this.isE.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.isE != null) {
                        b.this.isE.oV(cVar.value == 1);
                    }
                }
            }
        }.execute(this.isB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
