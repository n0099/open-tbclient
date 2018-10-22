package com.baidu.tieba.k;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.j.e;
import com.baidu.tieba.k.a;
import com.baidu.tieba.play.QuickVideoView;
import java.io.File;
/* loaded from: classes4.dex */
public class b implements e {
    private boolean fwU = false;
    private boolean fwV = false;
    private e.a fwW;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.j.e
    public void a(e.a aVar) {
        this.fwW = aVar;
    }

    @Override // com.baidu.tieba.j.e
    public void baZ() {
        if (f.Ix()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.gJ(this.mLocalPath)) {
                if (this.fwW != null) {
                    this.fwW.qT(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.k.b.1
                @Override // com.baidu.tieba.k.a.b
                public void qX(int i) {
                    if (i == 1) {
                        b.this.fwU = true;
                        b.this.bbC();
                    }
                    if (b.this.fwW != null) {
                        b.this.fwW.qT(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbC() {
        if (f.Ix()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.gJ(this.mLocalPath)) {
                if (this.fwW != null) {
                    this.fwW.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0224a() { // from class: com.baidu.tieba.k.b.2
                @Override // com.baidu.tieba.k.a.InterfaceC0224a
                public void jD(boolean z) {
                    if (b.this.fwU && z) {
                        b.this.fwV = true;
                    }
                    if (b.this.fwW != null) {
                        b.this.fwW.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bba() {
        if (f.Ix()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.fwU || !this.fwV) {
                if (this.fwW != null) {
                    this.fwW.jB(false);
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
                        return Boolean.valueOf(b.ce(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.fwW != null) {
                        b.this.fwW.jB(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.j.e
    public void bbb() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.gJ(this.mLocalPath)) {
            if (this.fwW != null) {
                this.fwW.qT(2);
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
                    int rH = a.rH(str);
                    publishProgress(new c(1, rH));
                    if (rH == 1) {
                        boolean cd = a.cd(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, cd ? 1 : 0);
                        publishProgress(cVarArr);
                        if (cd) {
                            boolean ce = b.ce(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, ce ? 1 : 0);
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
                        if (b.this.fwW != null) {
                            b.this.fwW.qT(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.fwW != null) {
                            b.this.fwW.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.fwW != null) {
                        b.this.fwW.jB(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ce(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
