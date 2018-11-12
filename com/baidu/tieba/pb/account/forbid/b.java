package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class b {
    private static final String fHB = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0271b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0271b interfaceC0271b) {
        new a(str, str2, interfaceC0271b).execute(new String[0]);
    }

    /* loaded from: classes6.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0271b> fHA;
        private String fHC;
        private String fHD;

        public a(String str, String str2, InterfaceC0271b interfaceC0271b) {
            this.fHC = str;
            this.fHD = str2;
            this.fHA = new WeakReference<>(interfaceC0271b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.fHB);
            xVar.x("forum_id", this.fHC);
            xVar.x("user_id", this.fHD);
            String BH = xVar.BH();
            if (xVar.Cf().De().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(BH, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.Cj();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0271b interfaceC0271b = this.fHA.get();
            if (interfaceC0271b != null) {
                if (forbidTplData.error.errno == 0 && ao.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0271b.a(forbidTplData);
                } else {
                    interfaceC0271b.b(forbidTplData);
                }
            }
        }
    }
}
