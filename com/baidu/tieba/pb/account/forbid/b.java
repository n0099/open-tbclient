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
    private static final String hiv = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0280b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0280b interfaceC0280b) {
        new a(str, str2, interfaceC0280b).execute(new String[0]);
    }

    /* loaded from: classes4.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0280b> hiu;
        private String hiw;
        private String hix;

        public a(String str, String str2, InterfaceC0280b interfaceC0280b) {
            this.hiw = str;
            this.hix = str2;
            this.hiu = new WeakReference<>(interfaceC0280b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.hiv);
            xVar.x("forum_id", this.hiw);
            xVar.x("user_id", this.hix);
            String acj = xVar.acj();
            if (xVar.acH().adG().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(acj, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.acL();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0280b interfaceC0280b = this.hiu.get();
            if (interfaceC0280b != null) {
                if (forbidTplData.error.errno == 0 && ap.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0280b.a(forbidTplData);
                } else {
                    interfaceC0280b.b(forbidTplData);
                }
            }
        }
    }
}
