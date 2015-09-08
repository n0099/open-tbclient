package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String bZs = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORBID_USER_ADDRESS;

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
        private String Af;
        private WeakReference<b> aGw;
        private String aju;
        private String bZt;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.aju = str4;
            this.bZt = str6;
            this.Af = str7;
            this.mPostId = str5;
            this.aGw = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: v */
        public ForbidResultData doInBackground(String... strArr) {
            v vVar = new v(f.bZs);
            vVar.o("day", this.bZt);
            vVar.o("un", this.aju);
            vVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            vVar.o("word", this.mForumName);
            vVar.o("z", this.mThreadId);
            vVar.o("reason", this.Af);
            vVar.o("ntn", "banid");
            vVar.o("post_id", this.mPostId);
            vVar.uj().uZ().mIsNeedTbs = true;
            String tI = vVar.tI();
            if (vVar.uj().va().qZ()) {
                try {
                    return (ForbidResultData) i.objectWithJsonStr(tI, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = vVar.un();
            forbidResultData2.error_msg = vVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.aGw.get();
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
