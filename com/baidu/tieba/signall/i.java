package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class i {
    private int forumId;
    private String forumName;
    private a mHz = new a();
    private int mIP;
    private int mIQ;
    private int mIR;
    private int mIS;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dFe() {
        return this.signed;
    }

    public int dFf() {
        return this.mIR;
    }

    public int getCurScore() {
        return this.mIS;
    }

    public a dEA() {
        return this.mHz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mHz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.mIP = jSONObject.optInt("is_on");
                this.mIQ = jSONObject.optInt("is_filter");
                this.mIR = jSONObject.optInt("sign_day_count");
                this.mIS = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
