package com.baidu.tieba.pb.account.forbid;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Object, ForbidResultData> {
    private String At;
    private String aec;
    private WeakReference<j> ayj;
    private String bIN;
    private String mForumId;
    private String mForumName;
    private String mPostId;
    private String mThreadId;

    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, j jVar) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mThreadId = str3;
        this.aec = str4;
        this.bIN = str6;
        this.At = str7;
        this.mPostId = str5;
        this.ayj = new WeakReference<>(jVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public ForbidResultData doInBackground(String... strArr) {
        String str;
        str = h.bIM;
        aa aaVar = new aa(str);
        aaVar.o("day", this.bIN);
        aaVar.o("un", this.aec);
        aaVar.o(ImageViewerConfig.FORUM_ID, this.mForumId);
        aaVar.o("word", this.mForumName);
        aaVar.o("z", this.mThreadId);
        aaVar.o("reason", this.At);
        aaVar.o("ntn", "banid");
        aaVar.o("post_id", this.mPostId);
        aaVar.sX().tS().mIsNeedTbs = true;
        String sw = aaVar.sw();
        if (aaVar.sX().tT().qa()) {
            try {
                return (ForbidResultData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(sw, ForbidResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                ForbidResultData forbidResultData = new ForbidResultData();
                forbidResultData.error_code = -1000;
                return forbidResultData;
            }
        }
        ForbidResultData forbidResultData2 = new ForbidResultData();
        forbidResultData2.error_code = aaVar.tb();
        forbidResultData2.error_msg = aaVar.getErrorString();
        return forbidResultData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(ForbidResultData forbidResultData) {
        super.onPostExecute(forbidResultData);
        j jVar = this.ayj.get();
        if (jVar != null) {
            if (forbidResultData.error_code == 0 && bb.isEmpty(forbidResultData.error_msg)) {
                jVar.a(forbidResultData);
            } else {
                jVar.b(forbidResultData);
            }
        }
    }
}
