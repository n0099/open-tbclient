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
    private static final String eCi = TbConfig.SERVER_ADDRESS + "c/u/bawu/listreason";

    /* renamed from: com.baidu.tieba.pb.account.forbid.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, InterfaceC0109b interfaceC0109b) {
        new a(str, str2, interfaceC0109b).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String aXJ;
        private String aXK;
        private WeakReference<InterfaceC0109b> aXN;

        public a(String str, String str2, InterfaceC0109b interfaceC0109b) {
            this.aXJ = str;
            this.aXK = str2;
            this.aXN = new WeakReference<>(interfaceC0109b);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public ForbidTplData doInBackground(String... strArr) {
            w wVar = new w(b.eCi);
            wVar.n("forum_id", this.aXJ);
            wVar.n("user_id", this.aXK);
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
            InterfaceC0109b interfaceC0109b = this.aXN.get();
            if (interfaceC0109b != null) {
                if (forbidTplData.error.errno == 0 && al.isEmpty(forbidTplData.error.errMsg)) {
                    interfaceC0109b.a(forbidTplData);
                } else {
                    interfaceC0109b.b(forbidTplData);
                }
            }
        }
    }
}
