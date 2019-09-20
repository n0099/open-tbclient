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
    private static final String hIF = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0386b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0386b interfaceC0386b) {
        new a(str, str2, interfaceC0386b).execute(new String[0]);
    }

    /* loaded from: classes4.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String hIG;
        private String hIH;
        private InterfaceC0386b hII;

        public a(String str, String str2, InterfaceC0386b interfaceC0386b) {
            this.hIG = str;
            this.hIH = str2;
            this.hII = interfaceC0386b;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.hIF);
            xVar.o("forum_id", this.hIG);
            xVar.o("user_id", this.hIH);
            String aim = xVar.aim();
            if (xVar.aiK().ajN().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(aim, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.aiO();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            if (this.hII != null) {
                if (forbidTplData.error.errno == 0 && aq.isEmpty(forbidTplData.error.errMsg)) {
                    this.hII.a(forbidTplData);
                } else {
                    this.hII.b(forbidTplData);
                }
            }
        }
    }
}
