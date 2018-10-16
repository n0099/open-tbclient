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
    private static final String fGc = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0244b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0244b interfaceC0244b) {
        new a(str, str2, interfaceC0244b).execute(new String[0]);
    }

    /* loaded from: classes6.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0244b> fGb;
        private String fGd;
        private String fGe;

        public a(String str, String str2, InterfaceC0244b interfaceC0244b) {
            this.fGd = str;
            this.fGe = str2;
            this.fGb = new WeakReference<>(interfaceC0244b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.fGc);
            xVar.x("forum_id", this.fGd);
            xVar.x("user_id", this.fGe);
            String BA = xVar.BA();
            if (xVar.BY().CX().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(BA, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.Cc();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0244b interfaceC0244b = this.fGb.get();
            if (interfaceC0244b != null) {
                if (forbidTplData.error.errno == 0 && ao.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0244b.a(forbidTplData);
                } else {
                    interfaceC0244b.b(forbidTplData);
                }
            }
        }
    }
}
