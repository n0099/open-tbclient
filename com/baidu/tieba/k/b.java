package com.baidu.tieba.k;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.j.e;
import com.baidu.tieba.k.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes8.dex */
public class b implements e {
    private String ioS;
    private boolean ioT = false;
    private boolean ioU = false;
    private e.a ioV;

    public b(String str) {
        this.ioS = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.ioV = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void ceR() {
        if (f.aJD()) {
            if (StringUtils.isNull(this.ioS) || !QuickVideoView.uh(this.ioS)) {
                if (this.ioV != null) {
                    this.ioV.ya(2);
                    return;
                }
                return;
            }
            a.a(this.ioS, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.ioT = true;
                        b.this.cfx();
                    }
                    if (b.this.ioV != null) {
                        b.this.ioV.ya(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        if (f.aJD()) {
            if (StringUtils.isNull(this.ioS) || !QuickVideoView.uh(this.ioS)) {
                if (this.ioV != null) {
                    this.ioV.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.ioS, this.ioS + "_moov_head_suffix", new a.InterfaceC0538a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0538a
                public void oP(boolean z) {
                    if (b.this.ioT && z) {
                        b.this.ioU = true;
                    }
                    if (b.this.ioV != null) {
                        b.this.ioV.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void ceS() {
        if (f.aJD()) {
            if (StringUtils.isNull(this.ioS) || !new File(this.ioS).exists() || !new File(this.ioS + "_moov_head_suffix").exists() || !this.ioT || !this.ioU) {
                if (this.ioV != null) {
                    this.ioV.oM(false);
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
                        return Boolean.valueOf(b.dP(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.ioV != null) {
                        b.this.ioV.oM(bool.booleanValue());
                    }
                }
            }.execute(this.ioS);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void ceT() {
        if (StringUtils.isNull(this.ioS) || !QuickVideoView.uh(this.ioS)) {
            if (this.ioV != null) {
                this.ioV.ya(2);
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
                    int EU = a.EU(str);
                    publishProgress(new c(1, EU));
                    if (EU == 1) {
                        boolean dO = a.dO(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, dO ? 1 : 0);
                        publishProgress(cVarArr);
                        if (dO) {
                            boolean dP = b.dP(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, dP ? 1 : 0);
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
                        if (b.this.ioV != null) {
                            b.this.ioV.ya(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.ioV != null) {
                            b.this.ioV.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.ioV != null) {
                        b.this.ioV.oM(cVar.value == 1);
                    }
                }
            }
        }.execute(this.ioS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dP(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
