package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.game.GameInfoData;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.aa ZD;
    private final String ckk;
    private final g ckl;
    final /* synthetic */ e ckm;
    private final String mForumId;
    private final String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        w wVar;
        try {
            this.ZD = new com.baidu.tbadk.core.util.aa(strArr[0]);
            this.ZD.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.ZD.o("kw", this.mForumName);
            this.ZD.o("is_like", this.ckk);
            this.ZD.sp().tp().mIsNeedTbs = true;
            String rO = this.ZD.rO();
            if (this.ZD.ss()) {
                if (this.ckk.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    try {
                        JSONObject jSONObject = new JSONObject(rO);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.ckl.level = optJSONObject.optInt("level_id", 0);
                            this.ckl.ckq = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.ckl.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.ckl.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.ckl.cko = true;
                        }
                        wVar = this.ckm.ckd;
                        wVar.a(this.ckl);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.ZD.sp().tq().pv()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(rO);
                        this.ckl.ckp = jSONObject2.optInt("num");
                        this.ckl.ckn = true;
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
        if (this.ZD != null) {
            this.ZD.hh();
        }
        this.ckm.cki = null;
        this.ckm.eJ(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        z zVar;
        z zVar2;
        this.ckm.cki = null;
        this.ckm.eJ(false);
        if (this.ZD != null) {
            h hVar = new h();
            hVar.errorMsg = this.ZD.getErrorString();
            hVar.errorCode = this.ZD.st();
            zVar = this.ckm.ckf;
            if (zVar != null) {
                zVar2 = this.ckm.ckf;
                zVar2.a(this.ckl, hVar);
            }
        }
    }
}
