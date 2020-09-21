package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class i {
    private int forumId;
    private String forumName;
    private a mfq = new a();
    private int mgC;
    private int mgD;
    private int mgE;
    private int mgF;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dyl() {
        return this.signed;
    }

    public int dym() {
        return this.mgE;
    }

    public int getCurScore() {
        return this.mgF;
    }

    public a dxH() {
        return this.mfq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mfq.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.mgC = jSONObject.optInt("is_on");
                this.mgD = jSONObject.optInt("is_filter");
                this.mgE = jSONObject.optInt("sign_day_count");
                this.mgF = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
