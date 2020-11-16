package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
import java.lang.ref.WeakReference;
/* loaded from: classes21.dex */
public class a {
    private static final String llB = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes21.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0810a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C0810a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String ffB;
        private String ffF;
        private String llC;
        private WeakReference<b> llD;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mReason;
        private String mThreadId;
        private String mUserName;

        public C0810a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.llC = str6;
            this.ffF = str8;
            this.ffB = str9;
            this.mReason = str7;
            this.mPostId = str5;
            this.llD = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: Q */
        public ForbidResultData doInBackground(String... strArr) {
            aa aaVar = new aa(a.llB);
            aaVar.addPostData("day", this.llC);
            aaVar.addPostData("un", this.mUserName);
            aaVar.addPostData("fid", this.mForumId);
            aaVar.addPostData("word", this.mForumName);
            aaVar.addPostData(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, this.mThreadId);
            aaVar.addPostData(TiebaInitialize.LogFields.REASON, this.mReason);
            aaVar.addPostData("ntn", "banid");
            aaVar.addPostData("post_id", this.mPostId);
            aaVar.addPostData("nick_name", this.ffF);
            aaVar.addPostData("portrait", this.ffB);
            aaVar.bqa().bqH().mIsNeedTbs = true;
            String postNetData = aaVar.postNetData();
            if (aaVar.bqa().bqI().isRequestSuccess()) {
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
            forbidResultData2.error_code = aaVar.getServerErrorCode();
            forbidResultData2.error_msg = aaVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.llD.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && au.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
