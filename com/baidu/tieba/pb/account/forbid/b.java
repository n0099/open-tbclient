package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes16.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0713b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0713b interfaceC0713b) {
        new a(str, str2, interfaceC0713b).execute(new String[0]);
    }

    /* loaded from: classes16.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String kfJ;
        private String kfK;
        private InterfaceC0713b kfL;

        public a(String str, String str2, InterfaceC0713b interfaceC0713b) {
            this.kfJ = str;
            this.kfK = str2;
            this.kfL = interfaceC0713b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public ForbidTplData doInBackground(String... strArr) {
            z zVar = new z(b.BAWU_LIST_REASON);
            zVar.addPostData("forum_id", this.kfJ);
            zVar.addPostData("user_id", this.kfK);
            String postNetData = zVar.postNetData();
            if (zVar.bav().baX().isRequestSuccess()) {
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
            forbidTplData2.error.errno = zVar.getServerErrorCode();
            forbidTplData2.error.errMsg = zVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.kfL != null) {
                if (forbidTplData.error.errno == 0 && as.isEmpty(forbidTplData.error.errMsg)) {
                    this.kfL.a(forbidTplData);
                } else {
                    this.kfL.b(forbidTplData);
                }
            }
        }
    }
}
