package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class b {
    private static final String fmR = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0205b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0205b interfaceC0205b) {
        new a(str, str2, interfaceC0205b).execute(new String[0]);
    }

    /* loaded from: classes2.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0205b> fmQ;
        private String fmS;
        private String fmT;

        public a(String str, String str2, InterfaceC0205b interfaceC0205b) {
            this.fmS = str;
            this.fmT = str2;
            this.fmQ = new WeakReference<>(interfaceC0205b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidTplData doInBackground(String... strArr) {
            y yVar = new y(b.fmR);
            yVar.o("forum_id", this.fmS);
            yVar.o("user_id", this.fmT);
            String yl = yVar.yl();
            if (yVar.yJ().zJ().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(yl, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = yVar.yN();
            forbidTplData2.error.errMsg = yVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0205b interfaceC0205b = this.fmQ.get();
            if (interfaceC0205b != null) {
                if (forbidTplData.error.errno == 0 && ao.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0205b.a(forbidTplData);
                } else {
                    interfaceC0205b.b(forbidTplData);
                }
            }
        }
    }
}
