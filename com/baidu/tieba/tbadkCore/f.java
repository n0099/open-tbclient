package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.aa ZF;
    private final String ckA;
    private final g ckB;
    final /* synthetic */ e ckC;
    private final String mForumId;
    private final String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        w wVar;
        try {
            this.ZF = new com.baidu.tbadk.core.util.aa(strArr[0]);
            this.ZF.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ZF.o("kw", this.mForumName);
            this.ZF.o("is_like", this.ckA);
            this.ZF.sp().tp().mIsNeedTbs = true;
            String rO = this.ZF.rO();
            if (this.ZF.ss()) {
                if (this.ckA.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    try {
                        JSONObject jSONObject = new JSONObject(rO);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.ckB.level = optJSONObject.optInt("level_id", 0);
                            this.ckB.ckG = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.ckB.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.ckB.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.ckB.ckE = true;
                        }
                        wVar = this.ckC.ckt;
                        wVar.a(this.ckB);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.ZF.sp().tq().pv()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(rO);
                        this.ckB.ckF = jSONObject2.optInt("num");
                        this.ckB.ckD = true;
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
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.ckC.cky = null;
        this.ckC.eH(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        z zVar;
        z zVar2;
        this.ckC.cky = null;
        this.ckC.eH(false);
        if (this.ZF != null) {
            h hVar = new h();
            hVar.errorMsg = this.ZF.getErrorString();
            hVar.errorCode = this.ZF.st();
            zVar = this.ckC.ckv;
            if (zVar != null) {
                zVar2 = this.ckC.ckv;
                zVar2.a(this.ckB, hVar);
            }
        }
    }
}
