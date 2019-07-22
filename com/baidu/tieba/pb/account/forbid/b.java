package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes4.dex */
public class b {
    private static final String hFR = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0369b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0369b interfaceC0369b) {
        new a(str, str2, interfaceC0369b).execute(new String[0]);
    }

    /* loaded from: classes4.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String hFS;
        private String hFT;
        private InterfaceC0369b hFU;

        public a(String str, String str2, InterfaceC0369b interfaceC0369b) {
            this.hFS = str;
            this.hFT = str2;
            this.hFU = interfaceC0369b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.hFR);
            xVar.o("forum_id", this.hFS);
            xVar.o("user_id", this.hFT);
            String aig = xVar.aig();
            if (xVar.aiE().ajF().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(aig, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.aiI();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.hFU != null) {
                if (forbidTplData.error.errno == 0 && aq.isEmpty(forbidTplData.error.errMsg)) {
                    this.hFU.a(forbidTplData);
                } else {
                    this.hFU.b(forbidTplData);
                }
            }
        }
    }
}
