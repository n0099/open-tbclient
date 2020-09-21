package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes21.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0761b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0761b interfaceC0761b) {
        new a(str, str2, interfaceC0761b).execute(new String[0]);
    }

    /* loaded from: classes21.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String kDI;
        private String kDJ;
        private InterfaceC0761b kDK;

        public a(String str, String str2, InterfaceC0761b interfaceC0761b) {
            this.kDI = str;
            this.kDJ = str2;
            this.kDK = interfaceC0761b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public ForbidTplData doInBackground(String... strArr) {
            aa aaVar = new aa(b.BAWU_LIST_REASON);
            aaVar.addPostData("forum_id", this.kDI);
            aaVar.addPostData("user_id", this.kDJ);
            String postNetData = aaVar.postNetData();
            if (aaVar.bjL().bkr().isRequestSuccess()) {
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
            if (this.kDK != null) {
                if (forbidTplData.error.errno == 0 && at.isEmpty(forbidTplData.error.errMsg)) {
                    this.kDK.a(forbidTplData);
                } else {
                    this.kDK.b(forbidTplData);
                }
            }
        }
    }
}
