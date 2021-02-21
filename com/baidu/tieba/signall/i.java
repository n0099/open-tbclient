package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private int forumId;
    private String forumName;
    private a nnI = new a();
    private int noV;
    private int noW;
    private int noX;
    private int noY;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dLi() {
        return this.signed;
    }

    public int dLj() {
        return this.noX;
    }

    public int getCurScore() {
        return this.noY;
    }

    public a dKF() {
        return this.nnI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.nnI.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.noV = jSONObject.optInt("is_on");
                this.noW = jSONObject.optInt("is_filter");
                this.noX = jSONObject.optInt("sign_day_count");
                this.noY = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
