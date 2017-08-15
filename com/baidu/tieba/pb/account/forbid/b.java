package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b {
    private static final String eEc = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0110b interfaceC0110b) {
        new a(str, str2, interfaceC0110b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String aXK;
        private String aXL;
        private WeakReference<InterfaceC0110b> aXO;

        public a(String str, String str2, InterfaceC0110b interfaceC0110b) {
            this.aXK = str;
            this.aXL = str2;
            this.aXO = new WeakReference<>(interfaceC0110b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForbidTplData doInBackground(String... strArr) {
            w wVar = new w(b.eEc);
            wVar.n("forum_id", this.aXK);
            wVar.n("user_id", this.aXL);
            String uO = wVar.uO();
            if (wVar.vl().wi().isRequestSuccess()) {
                try {
                    return (ForbidTplData) OrmObject.objectWithJsonStr(uO, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = wVar.vp();
            forbidTplData2.error.errMsg = wVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            InterfaceC0110b interfaceC0110b = this.aXO.get();
            if (interfaceC0110b != null) {
                if (forbidTplData.error.errno == 0 && al.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0110b.a(forbidTplData);
                } else {
                    interfaceC0110b.b(forbidTplData);
                }
            }
        }
    }
}
