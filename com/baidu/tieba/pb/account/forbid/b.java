package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes2.dex */
public class b {
    private static final String BAWU_LIST_REASON = TbConfig.SERVER_ADDRESS + Config.BAWU_LIST_REASON;

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0810b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0810b interfaceC0810b) {
        new a(str, str2, interfaceC0810b).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String lEm;
        private String lEn;
        private InterfaceC0810b lEo;

        public a(String str, String str2, InterfaceC0810b interfaceC0810b) {
            this.lEm = str;
            this.lEn = str2;
            this.lEo = interfaceC0810b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: X */
        public ForbidTplData doInBackground(String... strArr) {
            z zVar = new z(b.BAWU_LIST_REASON);
            zVar.addPostData("forum_id", this.lEm);
            zVar.addPostData("user_id", this.lEn);
            String postNetData = zVar.postNetData();
            if (zVar.bvQ().bwA().isRequestSuccess()) {
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
            if (this.lEo != null) {
                if (forbidTplData.error.errno == 0 && at.isEmpty(forbidTplData.error.errMsg)) {
                    this.lEo.a(forbidTplData);
                } else {
                    this.lEo.b(forbidTplData);
                }
            }
        }
    }
}
