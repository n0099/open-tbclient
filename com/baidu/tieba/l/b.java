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
    private String iqP;
    private boolean iqQ = false;
    private boolean iqR = false;
    private e.a iqS;

    public b(String str) {
        this.iqP = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.iqS = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cgx() {
        if (f.aLZ()) {
            if (StringUtils.isNull(this.iqP) || !QuickVideoView.uy(this.iqP)) {
                if (this.iqS != null) {
                    this.iqS.yg(2);
                    return;
                }
                return;
            }
            a.a(this.iqP, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.iqQ = true;
                        b.this.che();
                    }
                    if (b.this.iqS != null) {
                        b.this.iqS.yg(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        if (f.aLZ()) {
            if (StringUtils.isNull(this.iqP) || !QuickVideoView.uy(this.iqP)) {
                if (this.iqS != null) {
                    this.iqS.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.iqP, this.iqP + "_moov_head_suffix", new a.InterfaceC0545a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0545a
                public void oS(boolean z) {
                    if (b.this.iqQ && z) {
                        b.this.iqR = true;
                    }
                    if (b.this.iqS != null) {
                        b.this.iqS.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgy() {
        if (f.aLZ()) {
            if (StringUtils.isNull(this.iqP) || !new File(this.iqP).exists() || !new File(this.iqP + "_moov_head_suffix").exists() || !this.iqQ || !this.iqR) {
                if (this.iqS != null) {
                    this.iqS.oP(false);
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
                        return Boolean.valueOf(b.dY(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.iqS != null) {
                        b.this.iqS.oP(bool.booleanValue());
                    }
                }
            }.execute(this.iqP);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgz() {
        if (StringUtils.isNull(this.iqP) || !QuickVideoView.uy(this.iqP)) {
            if (this.iqS != null) {
                this.iqS.yg(2);
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
                        boolean dX = a.dX(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dX ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dX) {
                            boolean dY = b.dY(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, dY ? 1 : 0);
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
                        if (b.this.iqS != null) {
                            b.this.iqS.yg(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.iqS != null) {
                            b.this.iqS.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.iqS != null) {
                        b.this.iqS.oP(cVar.value == 1);
                    }
                }
            }
        }.execute(this.iqP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dY(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
