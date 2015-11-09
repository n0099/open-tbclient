package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g {
    private static final String cfo = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/bawu/listreason";

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidTplData forbidTplData);

        void b(ForbidTplData forbidTplData);
    }

    public static void a(String str, String str2, b bVar) {
        new a(str, str2, bVar).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidTplData> {
        private String aEq;
        private String aEr;
        private WeakReference<b> aEu;

        public a(String str, String str2, b bVar) {
            this.aEq = str;
            this.aEr = str2;
            this.aEu = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public ForbidTplData doInBackground(String... strArr) {
            w wVar = new w(g.cfo);
            wVar.o("forum_id", this.aEq);
            wVar.o("user_id", this.aEr);
            String tG = wVar.tG();
            if (wVar.uh().va().qT()) {
                try {
                    return (ForbidTplData) i.objectWithJsonStr(tG, ForbidTplData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidTplData forbidTplData = new ForbidTplData();
                    forbidTplData.error.errno = -1000;
                    return forbidTplData;
                }
            }
            ForbidTplData forbidTplData2 = new ForbidTplData();
            forbidTplData2.error.errno = wVar.ul();
            forbidTplData2.error.errMsg = wVar.getErrorString();
            return forbidTplData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidTplData forbidTplData) {
            super.onPostExecute(forbidTplData);
            b bVar = this.aEu.get();
            if (bVar != null) {
                if (forbidTplData.error.errno == 0 && as.isEmpty(forbidTplData.error.errMsg)) {
                    bVar.a(forbidTplData);
                } else {
                    bVar.b(forbidTplData);
                }
            }
        }
    }
}
