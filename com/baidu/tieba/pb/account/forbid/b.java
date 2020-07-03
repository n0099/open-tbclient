package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes9.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0701b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0701b interfaceC0701b) {
        new a(str, str2, interfaceC0701b).execute(new String[0]);
    }

    /* loaded from: classes9.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String jXh;
        private String jXi;
        private InterfaceC0701b jXj;

        public a(String str, String str2, InterfaceC0701b interfaceC0701b) {
            this.jXh = str;
            this.jXi = str2;
            this.jXj = interfaceC0701b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public ForbidTplData doInBackground(String... strArr) {
            y yVar = new y(b.BAWU_LIST_REASON);
            yVar.addPostData("forum_id", this.jXh);
            yVar.addPostData("user_id", this.jXi);
            String postNetData = yVar.postNetData();
            if (yVar.aWu().aWW().isRequestSuccess()) {
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
            forbidTplData2.error.errno = yVar.getServerErrorCode();
            forbidTplData2.error.errMsg = yVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.jXj != null) {
                if (forbidTplData.error.errno == 0 && ar.isEmpty(forbidTplData.error.errMsg)) {
                    this.jXj.a(forbidTplData);
                } else {
                    this.jXj.b(forbidTplData);
                }
            }
        }
    }
}
