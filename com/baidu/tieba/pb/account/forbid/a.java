package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a {
    private static final String hGr = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes4.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0474a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0474a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String cxs;
        private String cxw;
        private String hGs;
        private WeakReference<b> hGt;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;
        private String sy;

        public C0474a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.hGs = str6;
            this.cxw = str8;
            this.cxs = str9;
            this.sy = str7;
            this.mPostId = str5;
            this.hGt = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForbidResultData doInBackground(String... strArr) {
            x xVar = new x(a.hGr);
            xVar.addPostData(Config.TRACE_VISIT_RECENT_DAY, this.hGs);
            xVar.addPostData("un", this.mUserName);
            xVar.addPostData("fid", this.mForumId);
            xVar.addPostData("word", this.mForumName);
            xVar.addPostData("z", this.mThreadId);
            xVar.addPostData(TiebaInitialize.LogFields.REASON, this.sy);
            xVar.addPostData("ntn", "banid");
            xVar.addPostData("post_id", this.mPostId);
            xVar.addPostData("nick_name", this.cxw);
            xVar.addPostData("portrait", this.cxs);
            xVar.amp().amP().mIsNeedTbs = true;
            String postNetData = xVar.postNetData();
            if (xVar.amp().amQ().isRequestSuccess()) {
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
            b bVar = this.hGt.get();
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
