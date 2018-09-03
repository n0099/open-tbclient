package com.baidu.tieba.k;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.j.e;
import com.baidu.tieba.k.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes2.dex */
public class b implements e {
    private boolean fhQ = false;
    private boolean fhR = false;
    private e.a fhS;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.fhS = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void aVy() {
        if (f.Fg()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.fY(this.mLocalPath)) {
                if (this.fhS != null) {
                    this.fhS.pR(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void pV(int i) {
                    if (i == 1) {
                        b.this.fhQ = true;
                        b.this.aWc();
                    }
                    if (b.this.fhS != null) {
                        b.this.fhS.pR(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWc() {
        if (f.Fg()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.fY(this.mLocalPath)) {
                if (this.fhS != null) {
                    this.fhS.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0188a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0188a
                public void iN(boolean z) {
                    if (b.this.fhQ && z) {
                        b.this.fhR = true;
                    }
                    if (b.this.fhS != null) {
                        b.this.fhS.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void aVz() {
        if (f.Fg()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.fhQ || !this.fhR) {
                if (this.fhS != null) {
                    this.fhS.iL(false);
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
                        return Boolean.valueOf(b.bK(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.fhS != null) {
                        b.this.fhS.iL(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void aVA() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.fY(this.mLocalPath)) {
            if (this.fhS != null) {
                this.fhS.pR(2);
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
                    int qC = a.qC(str);
                    publishProgress(new c(1, qC));
                    if (qC == 1) {
                        boolean bJ = a.bJ(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, bJ ? 1 : 0);
                        publishProgress(cVarArr);
                        if (bJ) {
                            boolean bK = b.bK(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, bK ? 1 : 0);
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
                        if (b.this.fhS != null) {
                            b.this.fhS.pR(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.fhS != null) {
                            b.this.fhS.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.fhS != null) {
                        b.this.fhS.iL(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bK(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
