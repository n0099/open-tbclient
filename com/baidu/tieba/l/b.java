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
    private String jrN;
    private boolean jrO = false;
    private boolean jrP = false;
    private e.a jrQ;

    public b(String str) {
        this.jrN = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.jrQ = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cya() {
        if (f.baJ()) {
            if (StringUtils.isNull(this.jrN) || !QuickVideoView.xw(this.jrN)) {
                if (this.jrQ != null) {
                    this.jrQ.zx(2);
                    return;
                }
                return;
            }
            a.a(this.jrN, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void n(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.jrO = true;
                        b.this.cyH();
                    }
                    if (b.this.jrQ != null) {
                        b.this.jrQ.zx(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        if (f.baJ()) {
            if (StringUtils.isNull(this.jrN) || !QuickVideoView.xw(this.jrN)) {
                if (this.jrQ != null) {
                    this.jrQ.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.jrN, this.jrN + "_moov_head_suffix", new a.InterfaceC0654a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0654a
                public void qz(boolean z) {
                    if (b.this.jrO && z) {
                        b.this.jrP = true;
                    }
                    if (b.this.jrQ != null) {
                        b.this.jrQ.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cyb() {
        if (f.baJ()) {
            if (StringUtils.isNull(this.jrN) || !new File(this.jrN).exists() || !new File(this.jrN + "_moov_head_suffix").exists() || !this.jrO || !this.jrP) {
                if (this.jrQ != null) {
                    this.jrQ.qw(false);
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
                        return Boolean.valueOf(b.eM(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.jrQ != null) {
                        b.this.jrQ.qw(bool.booleanValue());
                    }
                }
            }.execute(this.jrN);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cyc() {
        if (StringUtils.isNull(this.jrN) || !QuickVideoView.xw(this.jrN)) {
            if (this.jrQ != null) {
                this.jrQ.zx(2);
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
                    int ID = a.ID(str);
                    publishProgress(new c(1, ID));
                    if (ID == 1) {
                        boolean eL = a.eL(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, eL ? 1 : 0);
                        publishProgress(cVarArr);
                        if (eL) {
                            boolean eM = b.eM(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, eM ? 1 : 0);
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
                        if (b.this.jrQ != null) {
                            b.this.jrQ.zx(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.jrQ != null) {
                            b.this.jrQ.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.jrQ != null) {
                        b.this.jrQ.qw(cVar.value == 1);
                    }
                }
            }
        }.execute(this.jrN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eM(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
