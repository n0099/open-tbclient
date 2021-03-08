package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    private int forumId;
    private String forumName;
    private a npO = new a();
    private int nqZ;
    private int nra;
    private int nrb;
    private int nrc;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dLq() {
        return this.signed;
    }

    public int dLr() {
        return this.nrb;
    }

    public int getCurScore() {
        return this.nrc;
    }

    public a dKN() {
        return this.npO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.npO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.nqZ = jSONObject.optInt("is_on");
                this.nra = jSONObject.optInt("is_filter");
                this.nrb = jSONObject.optInt("sign_day_count");
                this.nrc = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
