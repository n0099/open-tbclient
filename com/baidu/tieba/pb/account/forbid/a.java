package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class a {
    private static final String jlR = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes9.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0630a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0630a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String dQb;
        private String dQf;
        private String jlS;
        private WeakReference<b> jlT;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mReason;
        private String mThreadId;
        private String mUserName;

        public C0630a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.jlS = str6;
            this.dQf = str8;
            this.dQb = str9;
            this.mReason = str7;
            this.mPostId = str5;
            this.jlT = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public ForbidResultData doInBackground(String... strArr) {
            x xVar = new x(a.jlR);
            xVar.addPostData("day", this.jlS);
            xVar.addPostData("un", this.mUserName);
            xVar.addPostData("fid", this.mForumId);
            xVar.addPostData("word", this.mForumName);
            xVar.addPostData("z", this.mThreadId);
            xVar.addPostData(TiebaInitialize.LogFields.REASON, this.mReason);
            xVar.addPostData("ntn", "banid");
            xVar.addPostData("post_id", this.mPostId);
            xVar.addPostData("nick_name", this.dQf);
            xVar.addPostData("portrait", this.dQb);
            xVar.aOw().aOW().mIsNeedTbs = true;
            String postNetData = xVar.postNetData();
            if (xVar.aOw().aOX().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(postNetData, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = xVar.getServerErrorCode();
            forbidResultData2.error_msg = xVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.jlT.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && aq.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
