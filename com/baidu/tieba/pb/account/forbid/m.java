package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private String awq;
    private String awr;
    private WeakReference<n> awu;

    public m(String str, String str2, n nVar) {
        this.awq = str;
        this.awr = str2;
        this.awu = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public ForbidTplData doInBackground(String... strArr) {
        String str;
        str = l.bFF;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.awq);
        aaVar.o("user_id", this.awr);
        String rO = aaVar.rO();
        if (aaVar.sp().tq().pv()) {
            try {
                return (ForbidTplData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, ForbidTplData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.errno = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.errno = aaVar.st();
        forbidTplData2.error.errMsg = aaVar.getErrorString();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidTplData forbidTplData) {
        super.onPostExecute(forbidTplData);
        n nVar = this.awu.get();
        if (nVar != null) {
            if (forbidTplData.error.errno == 0 && bd.isEmpty(forbidTplData.error.errMsg)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
