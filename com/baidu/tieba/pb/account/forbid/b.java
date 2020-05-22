package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes9.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0684b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0684b interfaceC0684b) {
        new a(str, str2, interfaceC0684b).execute(new String[0]);
    }

    /* loaded from: classes9.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String jCr;
        private String jCs;
        private InterfaceC0684b jCt;

        public a(String str, String str2, InterfaceC0684b interfaceC0684b) {
            this.jCr = str;
            this.jCs = str2;
            this.jCt = interfaceC0684b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.BAWU_LIST_REASON);
            xVar.addPostData("forum_id", this.jCr);
            xVar.addPostData("user_id", this.jCs);
            String postNetData = xVar.postNetData();
            if (xVar.aUA().aVb().isRequestSuccess()) {
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
            forbidTplData2.error.errno = xVar.getServerErrorCode();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.jCt != null) {
                if (forbidTplData.error.errno == 0 && aq.isEmpty(forbidTplData.error.errMsg)) {
                    this.jCt.a(forbidTplData);
                } else {
                    this.jCt.b(forbidTplData);
                }
            }
        }
    }
}
