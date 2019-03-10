package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a {
    private static final String his = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes4.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0279a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0279a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String HW;
        private String cba;
        private String cbe;
        private String hit;
        private WeakReference<b> hiu;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public C0279a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.hit = str6;
            this.cbe = str8;
            this.cba = str9;
            this.HW = str7;
            this.mPostId = str5;
            this.hiu = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public ForbidResultData doInBackground(String... strArr) {
            x xVar = new x(a.his);
            xVar.x("day", this.hit);
            xVar.x("un", this.mUserName);
            xVar.x(ImageViewerConfig.FORUM_ID, this.mForumId);
            xVar.x("word", this.mForumName);
            xVar.x("z", this.mThreadId);
            xVar.x("reason", this.HW);
            xVar.x("ntn", "banid");
            xVar.x("post_id", this.mPostId);
            xVar.x("nick_name", this.cbe);
            xVar.x(IntentConfig.PORTRAIT, this.cba);
            xVar.acH().adF().mIsNeedTbs = true;
            String acj = xVar.acj();
            if (xVar.acH().adG().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(acj, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = xVar.acL();
            forbidResultData2.error_msg = xVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.hiu.get();
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
