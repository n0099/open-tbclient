package com.baidu.tieba.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.i.e;
import com.baidu.tieba.j.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes2.dex */
public class b implements e {
    private boolean fwJ = false;
    private boolean fwK = false;
    private e.a fwL;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.i.e
    public void a(e.a aVar) {
        this.fwL = aVar;
    }

    @Override // com.baidu.tieba.i.e
    public void aWK() {
        if (f.IF()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ri(this.mLocalPath)) {
                if (this.fwL != null) {
                    this.fwL.sg(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.j.b.1
                @Override // com.baidu.tieba.j.a.b
                public void sk(int i) {
                    if (i == 1) {
                        b.this.fwJ = true;
                        b.this.aXm();
                    }
                    if (b.this.fwL != null) {
                        b.this.fwL.sg(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        if (f.IF()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ri(this.mLocalPath)) {
                if (this.fwL != null) {
                    this.fwL.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0187a() { // from class: com.baidu.tieba.j.b.2
                @Override // com.baidu.tieba.j.a.InterfaceC0187a
                public void jj(boolean z) {
                    if (b.this.fwJ && z) {
                        b.this.fwK = true;
                    }
                    if (b.this.fwL != null) {
                        b.this.fwL.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aWL() {
        if (f.IF()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.fwJ || !this.fwK) {
                if (this.fwL != null) {
                    this.fwL.jh(false);
                    return;
                }
                return;
            }
            new BdAsyncTask<String, Void, Boolean>() { // from class: com.baidu.tieba.j.b.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Boolean doInBackground(String... strArr) {
                    if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                        return Boolean.valueOf(b.bC(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.fwL != null) {
                        b.this.fwL.jh(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aWM() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.ri(this.mLocalPath)) {
            if (this.fwL != null) {
                this.fwL.sg(2);
                return;
            }
            return;
        }
        new BdAsyncTask<String, c, Void>() { // from class: com.baidu.tieba.j.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                if (strArr != null && strArr.length == 1 && !StringUtils.isNull(strArr[0])) {
                    String str = strArr[0];
                    int pJ = a.pJ(str);
                    publishProgress(new c(1, pJ));
                    if (pJ == 1) {
                        boolean bB = a.bB(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, bB ? 1 : 0);
                        publishProgress(cVarArr);
                        if (bB) {
                            boolean bC = b.bC(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, bC ? 1 : 0);
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
                        if (b.this.fwL != null) {
                            b.this.fwL.sg(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.fwL != null) {
                            b.this.fwL.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.fwL != null) {
                        b.this.fwL.jh(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bC(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
