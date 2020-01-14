package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jWZ = new a();
    private int jYj;
    private int jYk;
    private int jYl;
    private int jYm;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cHw() {
        return this.signed;
    }

    public int cHx() {
        return this.jYl;
    }

    public int getCurScore() {
        return this.jYm;
    }

    public a cGS() {
        return this.jWZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jWZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jYj = jSONObject.optInt("is_on");
                this.jYk = jSONObject.optInt("is_filter");
                this.jYl = jSONObject.optInt("sign_day_count");
                this.jYm = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
