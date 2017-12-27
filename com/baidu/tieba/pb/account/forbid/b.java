package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class b {
    private static final String fAl = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0139b interfaceC0139b) {
        new a(str, str2, interfaceC0139b).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0139b> bQA;
        private String bQw;
        private String bQx;

        public a(String str, String str2, InterfaceC0139b interfaceC0139b) {
            this.bQw = str;
            this.bQx = str2;
            this.bQA = new WeakReference<>(interfaceC0139b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.fAl);
            xVar.n("forum_id", this.bQw);
            xVar.n("user_id", this.bQx);
            String BP = xVar.BP();
            if (xVar.Cn().Dl().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(BP, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.Cr();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0139b interfaceC0139b = this.bQA.get();
            if (interfaceC0139b != null) {
                if (forbidTplData.error.errno == 0 && am.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0139b.a(forbidTplData);
                } else {
                    interfaceC0139b.b(forbidTplData);
                }
            }
        }
    }
}
