package com.baidu.tieba.pb.account.forbid;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a {
    private static final String fmO = TbConfig.SERVER_ADDRESS + TbConfig.FORBID_USER_ADDRESS;

    /* loaded from: classes2.dex */
    public interface b {
        void a(ForbidResultData forbidResultData);

        void b(ForbidResultData forbidResultData);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
        new C0204a(str, str2, str3, str4, str5, str6, str7, bVar).execute(new String[0]);
    }

    /* renamed from: com.baidu.tieba.pb.account.forbid.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0204a extends BdAsyncTask<String, Object, ForbidResultData> {
        private String ER;
        private String fmP;
        private WeakReference<b> fmQ;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;
        private String mUserName;

        public C0204a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.mUserName = str4;
            this.fmP = str6;
            this.ER = str7;
            this.mPostId = str5;
            this.fmQ = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public ForbidResultData doInBackground(String... strArr) {
            y yVar = new y(a.fmO);
            yVar.o("day", this.fmP);
            yVar.o("un", this.mUserName);
            yVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            yVar.o("word", this.mForumName);
            yVar.o("z", this.mThreadId);
            yVar.o("reason", this.ER);
            yVar.o("ntn", "banid");
            yVar.o("post_id", this.mPostId);
            yVar.yJ().zI().mIsNeedTbs = true;
            String yl = yVar.yl();
            if (yVar.yJ().zJ().isRequestSuccess()) {
                try {
                    return (ForbidResultData) OrmObject.objectWithJsonStr(yl, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = yVar.yN();
            forbidResultData2.error_msg = yVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.fmQ.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && ao.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
