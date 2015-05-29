package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Object, ForbidTplData> {
    private String aye;
    private String ayf;
    private WeakReference<n> ayi;

    public m(String str, String str2, n nVar) {
        this.aye = str;
        this.ayf = str2;
        this.ayi = new WeakReference<>(nVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public ForbidTplData doInBackground(String... strArr) {
        String str;
        str = l.bIN;
        aa aaVar = new aa(str);
        aaVar.o("forum_id", this.aye);
        aaVar.o("user_id", this.ayf);
        String sw = aaVar.sw();
        if (aaVar.sX().tT().qa()) {
            try {
                return (ForbidTplData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(sw, ForbidTplData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidTplData forbidTplData = new ForbidTplData();
                forbidTplData.error.errno = -1000;
                return forbidTplData;
            }
        }
        ForbidTplData forbidTplData2 = new ForbidTplData();
        forbidTplData2.error.errno = aaVar.tb();
        forbidTplData2.error.errMsg = aaVar.getErrorString();
        return forbidTplData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidTplData forbidTplData) {
        super.onPostExecute(forbidTplData);
        n nVar = this.ayi.get();
        if (nVar != null) {
            if (forbidTplData.error.errno == 0 && bb.isEmpty(forbidTplData.error.errMsg)) {
                nVar.a(forbidTplData);
            } else {
                nVar.b(forbidTplData);
            }
        }
    }
}
