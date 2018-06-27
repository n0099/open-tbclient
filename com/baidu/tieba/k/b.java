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
    private boolean fhK = false;
    private boolean fhL = false;
    private e.a fhM;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.fhM = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void aXj() {
        if (f.Fk()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ga(this.mLocalPath)) {
                if (this.fhM != null) {
                    this.fhM.pU(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void pY(int i) {
                    if (i == 1) {
                        b.this.fhK = true;
                        b.this.aXL();
                    }
                    if (b.this.fhM != null) {
                        b.this.fhM.pU(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXL() {
        if (f.Fk()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ga(this.mLocalPath)) {
                if (this.fhM != null) {
                    this.fhM.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0189a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0189a
                public void jb(boolean z) {
                    if (b.this.fhK && z) {
                        b.this.fhL = true;
                    }
                    if (b.this.fhM != null) {
                        b.this.fhM.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void aXk() {
        if (f.Fk()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.fhK || !this.fhL) {
                if (this.fhM != null) {
                    this.fhM.iZ(false);
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
                        return Boolean.valueOf(b.bO(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.fhM != null) {
                        b.this.fhM.iZ(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void aXl() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ga(this.mLocalPath)) {
            if (this.fhM != null) {
                this.fhM.pU(2);
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
                    int qG = a.qG(str);
                    publishProgress(new c(1, qG));
                    if (qG == 1) {
                        boolean bN = a.bN(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, bN ? 1 : 0);
                        publishProgress(cVarArr);
                        if (bN) {
                            boolean bO = b.bO(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, bO ? 1 : 0);
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
                        if (b.this.fhM != null) {
                            b.this.fhM.pU(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.fhM != null) {
                            b.this.fhM.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.fhM != null) {
                        b.this.fhM.iZ(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bO(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
