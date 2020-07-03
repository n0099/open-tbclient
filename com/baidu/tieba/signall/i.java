package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lwC = new a();
    private int lxO;
    private int lxP;
    private int lxQ;
    private int lxR;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dfI() {
        return this.signed;
    }

    public int dfJ() {
        return this.lxQ;
    }

    public int getCurScore() {
        return this.lxR;
    }

    public a dfe() {
        return this.lwC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lwC.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lxO = jSONObject.optInt("is_on");
                this.lxP = jSONObject.optInt("is_filter");
                this.lxQ = jSONObject.optInt("sign_day_count");
                this.lxR = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
