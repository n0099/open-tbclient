package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes21.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0811b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0811b interfaceC0811b) {
        new a(str, str2, interfaceC0811b).execute(new String[0]);
    }

    /* loaded from: classes21.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String llE;
        private String llF;
        private InterfaceC0811b llG;

        public a(String str, String str2, InterfaceC0811b interfaceC0811b) {
            this.llE = str;
            this.llF = str2;
            this.llG = interfaceC0811b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public ForbidTplData doInBackground(String... strArr) {
            aa aaVar = new aa(b.BAWU_LIST_REASON);
            aaVar.addPostData("forum_id", this.llE);
            aaVar.addPostData("user_id", this.llF);
            String postNetData = aaVar.postNetData();
            if (aaVar.bqa().bqI().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(postNetData, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = aaVar.getServerErrorCode();
            forbidTplData2.error.errMsg = aaVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.llG != null) {
                if (forbidTplData.error.errno == 0 && au.isEmpty(forbidTplData.error.errMsg)) {
                    this.llG.a(forbidTplData);
                } else {
                    this.llG.b(forbidTplData);
                }
            }
        }
    }
}
