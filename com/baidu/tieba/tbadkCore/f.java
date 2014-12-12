package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.ad CV;
    private final String bSd;
    private final g bSe;
    final /* synthetic */ e bSf;
    private final String mForumId;
    private final String mForumName;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(strArr[0]);
            this.CV.o(ImageViewerConfig.FORUM_ID, this.mForumId);
            this.CV.o("kw", this.mForumName);
            this.CV.o("is_like", this.bSd);
            this.CV.oW().pV().mIsNeedTbs = true;
            String ov = this.CV.ov();
            if (this.CV.oZ()) {
                if (this.bSd.equals("0")) {
                    try {
                        JSONObject jSONObject = new JSONObject(ov);
                        JSONObject optJSONObject = jSONObject.optJSONObject("like_data");
                        if (optJSONObject.optInt("is_success", 0) == 1) {
                            this.bSe.level = optJSONObject.optInt("level_id", 0);
                            this.bSe.bSj = optJSONObject.optString("level_name", "");
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_perm");
                            if (optJSONObject2 != null) {
                                this.bSe.cur_score = optJSONObject2.optInt("cur_score", 0);
                                this.bSe.levelup_score = optJSONObject2.optInt("levelup_score", 0);
                            }
                            this.bSe.bSh = true;
                        }
                        this.bSf.a(this.bSe);
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                if (this.CV.oW().pW().ma()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(ov);
                        this.bSe.bSi = jSONObject2.optInt("num");
                        this.bSe.bSg = true;
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
        if (this.CV != null) {
            this.CV.dL();
        }
        this.bSf.bSa = null;
        this.bSf.ep(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        w wVar;
        w wVar2;
        this.bSf.bSa = null;
        this.bSf.ep(false);
        if (this.CV != null) {
            h hVar = new h();
            hVar.errorMsg = this.CV.getErrorString();
            hVar.errorCode = this.CV.pa();
            wVar = this.bSf.bRX;
            if (wVar != null) {
                wVar2 = this.bSf.bRX;
                wVar2.a(this.bSe, hVar);
            }
        }
    }
}
