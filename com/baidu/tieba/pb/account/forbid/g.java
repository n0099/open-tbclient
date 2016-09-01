package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String eiv = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/bawu/listreason";

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
        private String aSN;
        private String aSO;
        private WeakReference<b> aSR;

        public a(String str, String str2, b bVar) {
            this.aSN = str;
            this.aSO = str2;
            this.aSR = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public ForbidTplData doInBackground(String... strArr) {
            ab abVar = new ab(g.eiv);
            abVar.n("forum_id", this.aSN);
            abVar.n("user_id", this.aSO);
            String ue = abVar.ue();
            if (abVar.uD().vA().oE()) {
                try {
                    return (ForbidTplData) i.objectWithJsonStr(ue, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = abVar.uH();
            forbidTplData2.error.errMsg = abVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            b bVar = this.aSR.get();
            if (bVar != null) {
                if (forbidTplData.error.errno == 0 && ba.isEmpty(forbidTplData.error.errMsg)) {
                    bVar.a(forbidTplData);
                } else {
                    bVar.b(forbidTplData);
                }
            }
        }
    }
}
