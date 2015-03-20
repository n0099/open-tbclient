package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private String AE;
    private String acM;
    private WeakReference<j> awu;
    private String bFE;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, j jVar) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.acM = str4;
        this.bFE = str6;
        this.AE = str7;
        this.mPostId = str5;
        this.awu = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.bFD;
        aa aaVar = new aa(str);
        aaVar.o("day", this.bFE);
        aaVar.o("un", this.acM);
        aaVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        aaVar.o("word", this.mForumName);
        aaVar.o("z", this.mThreadId);
        aaVar.o("reason", this.AE);
        aaVar.o("ntn", "banid");
        aaVar.o("post_id", this.mPostId);
        aaVar.sp().tp().mIsNeedTbs = true;
        String rO = aaVar.rO();
        if (aaVar.sp().tq().pv()) {
            try {
                return (ForbidResultData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(rO, ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.error_code = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.error_code = aaVar.st();
        forbidResultData2.error_msg = aaVar.getErrorString();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.awu.get();
        if (jVar != null) {
            if (forbidResultData.error_code == 0 && bd.isEmpty(forbidResultData.error_msg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
