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
    private static final String fqW = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0206b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0206b interfaceC0206b) {
        new a(str, str2, interfaceC0206b).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0206b> fqV;
        private String fqX;
        private String fqY;

        public a(String str, String str2, InterfaceC0206b interfaceC0206b) {
            this.fqX = str;
            this.fqY = str2;
            this.fqV = new WeakReference<>(interfaceC0206b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidTplData doInBackground(String... strArr) {
            y yVar = new y(b.fqW);
            yVar.o("forum_id", this.fqX);
            yVar.o("user_id", this.fqY);
            String yq = yVar.yq();
            if (yVar.yO().zN().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(yq, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = yVar.yS();
            forbidTplData2.error.errMsg = yVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0206b interfaceC0206b = this.fqV.get();
            if (interfaceC0206b != null) {
                if (forbidTplData.error.errno == 0 && ap.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0206b.a(forbidTplData);
                } else {
                    interfaceC0206b.b(forbidTplData);
                }
            }
        }
    }
}
