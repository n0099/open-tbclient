package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String dKf = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORBID_USER_ADDRESS;

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
        private WeakReference<b> aMD;
        private String dKg;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;
        private String qZ;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.dKg = str6;
            this.qZ = str7;
            this.mPostId = str5;
            this.aMD = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public ForbidResultData doInBackground(String... strArr) {
            ab abVar = new ab(f.dKf);
            abVar.n("day", this.dKg);
            abVar.n("un", this.mUserName);
            abVar.n("fid", this.mForumId);
            abVar.n("word", this.mForumName);
            abVar.n("z", this.mThreadId);
            abVar.n("reason", this.qZ);
            abVar.n("ntn", "banid");
            abVar.n("post_id", this.mPostId);
            abVar.ty().uu().mIsNeedTbs = true;
            String ta = abVar.ta();
            if (abVar.ty().uv().nU()) {
                try {
                    return (ForbidResultData) i.objectWithJsonStr(ta, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = abVar.tC();
            forbidResultData2.error_msg = abVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.aMD.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && ba.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
