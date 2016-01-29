package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String cHZ = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORBID_USER_ADDRESS;

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
        private String Aw;
        private WeakReference<b> aKa;
        private String cIa;
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
            this.cIa = str6;
            this.Aw = str7;
            this.mPostId = str5;
            this.aKa = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidResultData doInBackground(String... strArr) {
            aa aaVar = new aa(f.cHZ);
            aaVar.p("day", this.cIa);
            aaVar.p("un", this.mUserName);
            aaVar.p(ImageViewerConfig.FORUM_ID, this.mForumId);
            aaVar.p("word", this.mForumName);
            aaVar.p("z", this.mThreadId);
            aaVar.p("reason", this.Aw);
            aaVar.p("ntn", "banid");
            aaVar.p("post_id", this.mPostId);
            aaVar.vB().wv().mIsNeedTbs = true;
            String uZ = aaVar.uZ();
            if (aaVar.vB().ww().rl()) {
                try {
                    return (ForbidResultData) i.objectWithJsonStr(uZ, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = aaVar.vF();
            forbidResultData2.error_msg = aaVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.aKa.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && aw.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
