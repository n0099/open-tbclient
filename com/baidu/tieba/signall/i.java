package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lVO = new a();
    private int lXb;
    private int lXc;
    private int lXd;
    private int lXe;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dus() {
        return this.signed;
    }

    public int dut() {
        return this.lXd;
    }

    public int getCurScore() {
        return this.lXe;
    }

    public a dtO() {
        return this.lVO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lVO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lXb = jSONObject.optInt("is_on");
                this.lXc = jSONObject.optInt("is_filter");
                this.lXd = jSONObject.optInt("sign_day_count");
                this.lXe = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
