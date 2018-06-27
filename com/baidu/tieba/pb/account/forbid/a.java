package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a {
    private static final String fqH = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes2.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
        new C0206a(str, str2, str3, str4, str5, str6, str7, str8, str9, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0206a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String ET;
        private String aFL;
        private String aFP;
        private String fqI;
        private WeakReference<b> fqJ;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public C0206a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.fqI = str6;
            this.aFP = str8;
            this.aFL = str9;
            this.ET = str7;
            this.mPostId = str5;
            this.fqJ = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public ForbidResultData doInBackground(String... strArr) {
            y yVar = new y(a.fqH);
            yVar.o("day", this.fqI);
            yVar.o("un", this.mUserName);
            yVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            yVar.o("word", this.mForumName);
            yVar.o("z", this.mThreadId);
            yVar.o("reason", this.ET);
            yVar.o("ntn", "banid");
            yVar.o("post_id", this.mPostId);
            yVar.o("nick_name", this.aFP);
            yVar.o(IntentConfig.PORTRAIT, this.aFL);
            yVar.yX().zX().mIsNeedTbs = true;
            String yz = yVar.yz();
            if (yVar.yX().zY().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(yz, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = yVar.zb();
            forbidResultData2.error_msg = yVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.fqJ.get();
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
