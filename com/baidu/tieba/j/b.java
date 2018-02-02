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
    private boolean fti = false;
    private boolean ftj = false;
    private e.a ftk;
    private String mLocalPath;

    public b(String str) {
        this.mLocalPath = str;
    }

    @Override // com.baidu.tieba.i.e
    public void a(e.a aVar) {
        this.ftk = aVar;
    }

    @Override // com.baidu.tieba.i.e
    public void aVb() {
        if (f.HZ()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rc(this.mLocalPath)) {
                if (this.ftk != null) {
                    this.ftk.sd(2);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, new a.b() { // from class: com.baidu.tieba.j.b.1
                @Override // com.baidu.tieba.j.a.b
                public void sh(int i) {
                    if (i == 1) {
                        b.this.fti = true;
                        b.this.aVD();
                    }
                    if (b.this.ftk != null) {
                        b.this.ftk.sd(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVD() {
        if (f.HZ()) {
            if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rc(this.mLocalPath)) {
                if (this.ftk != null) {
                    this.ftk.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.mLocalPath, this.mLocalPath + "_moov_head_suffix", new a.InterfaceC0129a() { // from class: com.baidu.tieba.j.b.2
                @Override // com.baidu.tieba.j.a.InterfaceC0129a
                public void ja(boolean z) {
                    if (b.this.fti && z) {
                        b.this.ftj = true;
                    }
                    if (b.this.ftk != null) {
                        b.this.ftk.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aVc() {
        if (f.HZ()) {
            if (StringUtils.isNull(this.mLocalPath) || !new File(this.mLocalPath).exists() || !new File(this.mLocalPath + "_moov_head_suffix").exists() || !this.fti || !this.ftj) {
                if (this.ftk != null) {
                    this.ftk.iY(false);
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
                        return Boolean.valueOf(b.bB(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.ftk != null) {
                        b.this.ftk.iY(bool.booleanValue());
                    }
                }
            }.execute(this.mLocalPath);
        }
    }

    @Override // com.baidu.tieba.i.e
    public void aVd() {
        if (StringUtils.isNull(this.mLocalPath) || !QuickVideoView.rc(this.mLocalPath)) {
            if (this.ftk != null) {
                this.ftk.sd(2);
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
                    int pB = a.pB(str);
                    publishProgress(new c(1, pB));
                    if (pB == 1) {
                        boolean bA = a.bA(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, bA ? 1 : 0);
                        publishProgress(cVarArr);
                        if (bA) {
                            boolean bB = b.bB(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, bB ? 1 : 0);
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
                        if (b.this.ftk != null) {
                            b.this.ftk.sd(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.ftk != null) {
                            b.this.ftk.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.ftk != null) {
                        b.this.ftk.iY(cVar.value == 1);
                    }
                }
            }
        }.execute(this.mLocalPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bB(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
