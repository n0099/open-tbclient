package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a {
    private static final String hzB = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes4.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0369a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0369a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String FF;
        private String cjc;
        private String cjg;
        private String hzC;
        private WeakReference<b> hzD;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public C0369a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.hzC = str6;
            this.cjg = str8;
            this.cjc = str9;
            this.FF = str7;
            this.mPostId = str5;
            this.hzD = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public ForbidResultData doInBackground(String... strArr) {
            x xVar = new x(a.hzB);
            xVar.o(Config.TRACE_VISIT_RECENT_DAY, this.hzC);
            xVar.o("un", this.mUserName);
            xVar.o("fid", this.mForumId);
            xVar.o("word", this.mForumName);
            xVar.o("z", this.mThreadId);
            xVar.o("reason", this.FF);
            xVar.o("ntn", "banid");
            xVar.o("post_id", this.mPostId);
            xVar.o("nick_name", this.cjg);
            xVar.o(IntentConfig.PORTRAIT, this.cjc);
            xVar.ahC().aiB().mIsNeedTbs = true;
            String ahe = xVar.ahe();
            if (xVar.ahC().aiC().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(ahe, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = xVar.ahG();
            forbidResultData2.error_msg = xVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.hzD.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && ap.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
