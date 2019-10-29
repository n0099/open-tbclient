package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iZN = new a();
    private int jaX;
    private int jaY;
    private int jaZ;
    private int jba;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cmi() {
        return this.signed;
    }

    public int cmj() {
        return this.jaZ;
    }

    public int getCurScore() {
        return this.jba;
    }

    public a clE() {
        return this.iZN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iZN.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jaX = jSONObject.optInt("is_on");
                this.jaY = jSONObject.optInt("is_filter");
                this.jaZ = jSONObject.optInt("sign_day_count");
                this.jba = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
