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
    private String irb;
    private boolean irc = false;
    private boolean ird = false;
    private e.a ire;

    public b(String str) {
        this.irb = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.ire = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void cgy() {
        if (f.aMa()) {
            if (StringUtils.isNull(this.irb) || !QuickVideoView.uz(this.irb)) {
                if (this.ire != null) {
                    this.ire.yg(2);
                    return;
                }
                return;
            }
            a.a(this.irb, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.irc = true;
                        b.this.chf();
                    }
                    if (b.this.ire != null) {
                        b.this.ire.yg(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        if (f.aMa()) {
            if (StringUtils.isNull(this.irb) || !QuickVideoView.uz(this.irb)) {
                if (this.ire != null) {
                    this.ire.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.irb, this.irb + "_moov_head_suffix", new a.InterfaceC0545a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0545a
                public void oS(boolean z) {
                    if (b.this.irc && z) {
                        b.this.ird = true;
                    }
                    if (b.this.ire != null) {
                        b.this.ire.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgz() {
        if (f.aMa()) {
            if (StringUtils.isNull(this.irb) || !new File(this.irb).exists() || !new File(this.irb + "_moov_head_suffix").exists() || !this.irc || !this.ird) {
                if (this.ire != null) {
                    this.ire.oP(false);
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
                    if (b.this.ire != null) {
                        b.this.ire.oP(bool.booleanValue());
                    }
                }
            }.execute(this.irb);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void cgA() {
        if (StringUtils.isNull(this.irb) || !QuickVideoView.uz(this.irb)) {
            if (this.ire != null) {
                this.ire.yg(2);
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
                    int Fk = a.Fk(str);
                    publishProgress(new c(1, Fk));
                    if (Fk == 1) {
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
                        if (b.this.ire != null) {
                            b.this.ire.yg(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.ire != null) {
                            b.this.ire.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.ire != null) {
                        b.this.ire.oP(cVar.value == 1);
                    }
                }
            }
        }.execute(this.irb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dY(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
