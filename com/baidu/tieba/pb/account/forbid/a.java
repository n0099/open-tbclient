package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a {
    private static final String eMF = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
        new C0112a(str, str2, str3, str4, str5, str6, str7, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0112a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String Ae;
        private WeakReference<b> bcJ;
        private String eMG;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public C0112a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.eMG = str6;
            this.Ae = str7;
            this.mPostId = str5;
            this.bcJ = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidResultData doInBackground(String... strArr) {
            x xVar = new x(a.eMF);
            xVar.n("day", this.eMG);
            xVar.n("un", this.mUserName);
            xVar.n(ImageViewerConfig.FORUM_ID, this.mForumId);
            xVar.n("word", this.mForumName);
            xVar.n("z", this.mThreadId);
            xVar.n("reason", this.Ae);
            xVar.n("ntn", "banid");
            xVar.n("post_id", this.mPostId);
            xVar.uQ().vN().mIsNeedTbs = true;
            String us = xVar.us();
            if (xVar.uQ().vO().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(us, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = xVar.uU();
            forbidResultData2.error_msg = xVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.bcJ.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && am.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
