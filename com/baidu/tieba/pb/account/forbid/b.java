package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private static final String eCx = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0112b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0112b interfaceC0112b) {
        new a(str, str2, interfaceC0112b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private WeakReference<InterfaceC0112b> aXB;
        private String aXx;
        private String aXy;

        public a(String str, String str2, InterfaceC0112b interfaceC0112b) {
            this.aXx = str;
            this.aXy = str2;
            this.aXB = new WeakReference<>(interfaceC0112b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForbidTplData doInBackground(String... strArr) {
            x xVar = new x(b.eCx);
            xVar.n("forum_id", this.aXx);
            xVar.n("user_id", this.aXy);
            String uM = xVar.uM();
            if (xVar.vj().wg().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(uM, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = xVar.vn();
            forbidTplData2.error.errMsg = xVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0112b interfaceC0112b = this.aXB.get();
            if (interfaceC0112b != null) {
                if (forbidTplData.error.errno == 0 && am.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0112b.a(forbidTplData);
                } else {
                    interfaceC0112b.b(forbidTplData);
                }
            }
        }
    }
}
