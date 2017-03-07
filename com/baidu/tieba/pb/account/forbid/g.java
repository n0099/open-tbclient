package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String egm = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/bawu/listreason";

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, b bVar) {
        new a(str, str2, bVar).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String aVR;
        private String aVS;
        private WeakReference<b> aVV;

        public a(String str, String str2, b bVar) {
            this.aVR = str;
            this.aVS = str2;
            this.aVV = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public ForbidTplData doInBackground(String... strArr) {
            z zVar = new z(g.egm);
            zVar.n("forum_id", this.aVR);
            zVar.n("user_id", this.aVS);
            String uB = zVar.uB();
            if (zVar.uZ().vT().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(uB, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = zVar.vd();
            forbidTplData2.error.errMsg = zVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            b bVar = this.aVV.get();
            if (bVar != null) {
                if (forbidTplData.error.errno == 0 && au.isEmpty(forbidTplData.error.errMsg)) {
                    bVar.a(forbidTplData);
                } else {
                    bVar.b(forbidTplData);
                }
            }
        }
    }
}
