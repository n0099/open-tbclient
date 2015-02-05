package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.ad CU;
    private final String bTQ;
    private final g bTR;
    final /* synthetic */ e bTS;
    private final String mForumId;
    private final String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        try {
            this.CU = new com.baidu.tbadk.core.util.ad(strArr[0]);
            this.CU.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CU.o("kw", this.mForumName);
            this.CU.o("is_like", this.bTQ);
            this.CU.oS().pZ().mIsNeedTbs = true;
            String or = this.CU.or();
            if (this.CU.oV()) {
                if (this.bTQ.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(or);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.bTR.level = optJSONObject.optInt("level_id", 0);
                            this.bTR.bTW = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.bTR.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.bTR.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.bTR.bTU = true;
                        }
                        this.bTS.a(this.bTR);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.CU.oS().qa().lT()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(or);
                        this.bTR.bTV = jSONObject2.optInt("num");
                        this.bTR.bTT = true;
                    } catch (Exception e2) {
                        BdLog.detailException(e2);
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.bTS.bTN = null;
        this.bTS.ew(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        w wVar;
        w wVar2;
        this.bTS.bTN = null;
        this.bTS.ew(false);
        if (this.CU != null) {
            h hVar = new h();
            hVar.errorMsg = this.CU.getErrorString();
            hVar.errorCode = this.CU.oW();
            wVar = this.bTS.bTK;
            if (wVar != null) {
                wVar2 = this.bTS.bTK;
                wVar2.a(this.bTR, hVar);
            }
        }
    }
}
