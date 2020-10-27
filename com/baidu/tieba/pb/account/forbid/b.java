package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes22.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0794b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0794b interfaceC0794b) {
        new a(str, str2, interfaceC0794b).execute(new String[0]);
    }

    /* loaded from: classes22.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String lfs;
        private String lft;
        private InterfaceC0794b lfu;

        public a(String str, String str2, InterfaceC0794b interfaceC0794b) {
            this.lfs = str;
            this.lft = str2;
            this.lfu = interfaceC0794b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public ForbidTplData doInBackground(String... strArr) {
            aa aaVar = new aa(b.BAWU_LIST_REASON);
            aaVar.addPostData("forum_id", this.lfs);
            aaVar.addPostData("user_id", this.lft);
            String postNetData = aaVar.postNetData();
            if (aaVar.bon().boU().isRequestSuccess()) {
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
            if (this.lfu != null) {
                if (forbidTplData.error.errno == 0 && at.isEmpty(forbidTplData.error.errMsg)) {
                    this.lfu.a(forbidTplData);
                } else {
                    this.lfu.b(forbidTplData);
                }
            }
        }
    }
}
