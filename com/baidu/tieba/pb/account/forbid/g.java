package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String dbj = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/bawu/listreason";

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, b bVar) {
        new a(str, str2, bVar).execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String aMS;
        private String aMT;
        private WeakReference<b> aMW;

        public a(String str, String str2, b bVar) {
            this.aMS = str;
            this.aMT = str2;
            this.aMW = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForbidTplData doInBackground(String... strArr) {
            ab abVar = new ab(g.dbj);
            abVar.p("forum_id", this.aMS);
            abVar.p("user_id", this.aMT);
            String vw = abVar.vw();
            if (abVar.vU().wP().qC()) {
                try {
                    return (ForbidTplData) i.objectWithJsonStr(vw, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = abVar.vY();
            forbidTplData2.error.errMsg = abVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            b bVar = this.aMW.get();
            if (bVar != null) {
                if (forbidTplData.error.errno == 0 && ay.isEmpty(forbidTplData.error.errMsg)) {
                    bVar.a(forbidTplData);
                } else {
                    bVar.b(forbidTplData);
                }
            }
        }
    }
}
