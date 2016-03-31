package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String dbh = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
        new a(str, str2, str3, str4, str5, str6, str7, bVar).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String AN;
        private WeakReference<b> aMW;
        private String dbi;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.dbi = str6;
            this.AN = str7;
            this.mPostId = str5;
            this.aMW = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public ForbidResultData doInBackground(String... strArr) {
            ab abVar = new ab(f.dbh);
            abVar.p("day", this.dbi);
            abVar.p("un", this.mUserName);
            abVar.p("fid", this.mForumId);
            abVar.p("word", this.mForumName);
            abVar.p("z", this.mThreadId);
            abVar.p("reason", this.AN);
            abVar.p("ntn", "banid");
            abVar.p("post_id", this.mPostId);
            abVar.vU().wO().mIsNeedTbs = true;
            String vw = abVar.vw();
            if (abVar.vU().wP().qC()) {
                try {
                    return (ForbidResultData) i.objectWithJsonStr(vw, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = abVar.vY();
            forbidResultData2.error_msg = abVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.aMW.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && ay.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
