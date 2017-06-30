package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aw;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String epM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/bawu/listreason";

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, b bVar) {
        new a(str, str2, bVar).execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<b> aVB;
        private String aVx;
        private String aVy;

        public a(String str, String str2, b bVar) {
            this.aVx = str;
            this.aVy = str2;
            this.aVB = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForbidTplData doInBackground(String... strArr) {
            ab abVar = new ab(g.epM);
            abVar.n("forum_id", this.aVx);
            abVar.n("user_id", this.aVy);
            String uy = abVar.uy();
            if (abVar.uV().vS().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(uy, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = abVar.uZ();
            forbidTplData2.error.errMsg = abVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            b bVar = this.aVB.get();
            if (bVar != null) {
                if (forbidTplData.error.errno == 0 && aw.isEmpty(forbidTplData.error.errMsg)) {
                    bVar.a(forbidTplData);
                } else {
                    bVar.b(forbidTplData);
                }
            }
        }
    }
}
