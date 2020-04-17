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
    private String jcG;
    private boolean jcH = false;
    private boolean jcI = false;
    private e.a jcJ;

    public b(String str) {
        this.jcG = str;
    }

    @Override // com.baidu.tieba.k.e
    public void a(e.a aVar) {
        this.jcJ = aVar;
    }

    @Override // com.baidu.tieba.k.e
    public void crz() {
        if (f.aUB()) {
            if (StringUtils.isNull(this.jcG) || !QuickVideoView.vN(this.jcG)) {
                if (this.jcJ != null) {
                    this.jcJ.yP(2);
                    return;
                }
                return;
            }
            a.a(this.jcG, new a.b() { // from class: com.baidu.tieba.l.b.1
                @Override // com.baidu.tieba.l.a.b
                public void m(Integer num) {
                    if (num != null && num.intValue() == 1) {
                        b.this.jcH = true;
                        b.this.csg();
                    }
                    if (b.this.jcJ != null) {
                        b.this.jcJ.yP(num.intValue());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csg() {
        if (f.aUB()) {
            if (StringUtils.isNull(this.jcG) || !QuickVideoView.vN(this.jcG)) {
                if (this.jcJ != null) {
                    this.jcJ.onChange(false);
                    return;
                }
                return;
            }
            a.a(this.jcG, this.jcG + "_moov_head_suffix", new a.InterfaceC0583a() { // from class: com.baidu.tieba.l.b.2
                @Override // com.baidu.tieba.l.a.InterfaceC0583a
                public void qc(boolean z) {
                    if (b.this.jcH && z) {
                        b.this.jcI = true;
                    }
                    if (b.this.jcJ != null) {
                        b.this.jcJ.onChange(z);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e
    public void crA() {
        if (f.aUB()) {
            if (StringUtils.isNull(this.jcG) || !new File(this.jcG).exists() || !new File(this.jcG + "_moov_head_suffix").exists() || !this.jcH || !this.jcI) {
                if (this.jcJ != null) {
                    this.jcJ.pZ(false);
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
                        return Boolean.valueOf(b.el(strArr[0] + "_moov_head_suffix", strArr[0]));
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute((AnonymousClass3) bool);
                    if (b.this.jcJ != null) {
                        b.this.jcJ.pZ(bool.booleanValue());
                    }
                }
            }.execute(this.jcG);
        }
    }

    @Override // com.baidu.tieba.k.e
    public void crB() {
        if (StringUtils.isNull(this.jcG) || !QuickVideoView.vN(this.jcG)) {
            if (this.jcJ != null) {
                this.jcJ.yP(2);
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
                    int GR = a.GR(str);
                    publishProgress(new c(1, GR));
                    if (GR == 1) {
                        boolean ek = a.ek(str, str + "_moov_head_suffix");
                        c[] cVarArr = new c[1];
                        cVarArr[0] = new c(2, ek ? 1 : 0);
                        publishProgress(cVarArr);
                        if (ek) {
                            boolean el = b.el(str + "_moov_head_suffix", str);
                            c[] cVarArr2 = new c[1];
                            cVarArr2[0] = new c(3, el ? 1 : 0);
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
                        if (b.this.jcJ != null) {
                            b.this.jcJ.yP(cVar.value);
                        }
                    } else if (cVar.type == 2) {
                        if (b.this.jcJ != null) {
                            b.this.jcJ.onChange(cVar.value == 1);
                        }
                    } else if (cVar.type == 3 && b.this.jcJ != null) {
                        b.this.jcJ.pZ(cVar.value == 1);
                    }
                }
            }
        }.execute(this.jcG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean el(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2) || TextUtils.equals(str, str2) || !new File(str).exists() || !new File(str2).exists()) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }
}
