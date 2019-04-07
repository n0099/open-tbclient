package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private static final String hih = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0352b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0352b interfaceC0352b) {
        new a(str, str2, interfaceC0352b).execute(new String[0]);
    }

    /* loaded from: classes4.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0352b> hig;
        private String hii;
        private String hij;

        public a(String str, String str2, InterfaceC0352b interfaceC0352b) {
            this.hii = str;
            this.hij = str2;
            this.hig = new WeakReference<>(interfaceC0352b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.hih);
            xVar.x("forum_id", this.hii);
            xVar.x("user_id", this.hij);
            String acg = xVar.acg();
            if (xVar.acE().adD().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(acg, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.acI();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0352b interfaceC0352b = this.hig.get();
            if (interfaceC0352b != null) {
                if (forbidTplData.error.errno == 0 && ap.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0352b.a(forbidTplData);
                } else {
                    interfaceC0352b.b(forbidTplData);
                }
            }
        }
    }
}
