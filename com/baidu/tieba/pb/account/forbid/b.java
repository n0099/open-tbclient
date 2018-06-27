package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class b {
    private static final String fqK = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0207b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0207b interfaceC0207b) {
        new a(str, str2, interfaceC0207b).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0207b> fqJ;
        private String fqL;
        private String fqM;

        public a(String str, String str2, InterfaceC0207b interfaceC0207b) {
            this.fqL = str;
            this.fqM = str2;
            this.fqJ = new WeakReference<>(interfaceC0207b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForbidTplData doInBackground(String... strArr) {
            y yVar = new y(b.fqK);
            yVar.o("forum_id", this.fqL);
            yVar.o("user_id", this.fqM);
            String yz = yVar.yz();
            if (yVar.yX().zY().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(yz, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = yVar.zb();
            forbidTplData2.error.errMsg = yVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0207b interfaceC0207b = this.fqJ.get();
            if (interfaceC0207b != null) {
                if (forbidTplData.error.errno == 0 && ap.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0207b.a(forbidTplData);
                } else {
                    interfaceC0207b.b(forbidTplData);
                }
            }
        }
    }
}
