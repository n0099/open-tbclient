package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private static final String ceA = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORBID_USER_ADDRESS;

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
        private String Ag;
        private WeakReference<b> aFp;
        private String aiq;
        private String ceB;
        private String mForumId;
        private String mForumName;
        private String mPostId;
        private String mThreadId;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
            this.mForumId = str;
            this.mForumName = str2;
            this.mThreadId = str3;
            this.aiq = str4;
            this.ceB = str6;
            this.Ag = str7;
            this.mPostId = str5;
            this.aFp = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public ForbidResultData doInBackground(String... strArr) {
            w wVar = new w(f.ceA);
            wVar.o("day", this.ceB);
            wVar.o("un", this.aiq);
            wVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            wVar.o("word", this.mForumName);
            wVar.o("z", this.mThreadId);
            wVar.o("reason", this.Ag);
            wVar.o("ntn", "banid");
            wVar.o("post_id", this.mPostId);
            wVar.uh().uX().mIsNeedTbs = true;
            String tG = wVar.tG();
            if (wVar.uh().uY().qV()) {
                try {
                    return (ForbidResultData) i.objectWithJsonStr(tG, ForbidResultData.class);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    ForbidResultData forbidResultData = new ForbidResultData();
                    forbidResultData.error_code = -1000;
                    return forbidResultData;
                }
            }
            ForbidResultData forbidResultData2 = new ForbidResultData();
            forbidResultData2.error_code = wVar.ul();
            forbidResultData2.error_msg = wVar.getErrorString();
            return forbidResultData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForbidResultData forbidResultData) {
            super.onPostExecute(forbidResultData);
            b bVar = this.aFp.get();
            if (bVar != null) {
                if (forbidResultData.error_code == 0 && ar.isEmpty(forbidResultData.error_msg)) {
                    bVar.a(forbidResultData);
                } else {
                    bVar.b(forbidResultData);
                }
            }
        }
    }
}
