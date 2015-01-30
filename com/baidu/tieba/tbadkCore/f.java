package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.ad CX;
    private final String bTR;
    private final g bTS;
    final /* synthetic */ e bTT;
    private final String mForumId;
    private final String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        try {
            this.CX = new com.baidu.tbadk.core.util.ad(strArr[0]);
            this.CX.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CX.o("kw", this.mForumName);
            this.CX.o("is_like", this.bTR);
            this.CX.oZ().qg().mIsNeedTbs = true;
            String oy = this.CX.oy();
            if (this.CX.pc()) {
                if (this.bTR.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(oy);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.bTS.level = optJSONObject.optInt("level_id", 0);
                            this.bTS.bTX = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.bTS.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.bTS.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.bTS.bTV = true;
                        }
                        this.bTT.a(this.bTS);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.CX.oZ().qh().ma()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(oy);
                        this.bTS.bTW = jSONObject2.optInt("num");
                        this.bTS.bTU = true;
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
        if (this.CX != null) {
            this.CX.dJ();
        }
        this.bTT.bTO = null;
        this.bTT.ew(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        w wVar;
        w wVar2;
        this.bTT.bTO = null;
        this.bTT.ew(false);
        if (this.CX != null) {
            h hVar = new h();
            hVar.errorMsg = this.CX.getErrorString();
            hVar.errorCode = this.CX.pd();
            wVar = this.bTT.bTL;
            if (wVar != null) {
                wVar2 = this.bTT.bTL;
                wVar2.a(this.bTS, hVar);
            }
        }
    }
}
