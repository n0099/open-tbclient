package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jZP = new a();
    private int kaZ;
    private int kba;
    private int kbb;
    private int kbc;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cJx() {
        return this.signed;
    }

    public int cJy() {
        return this.kbb;
    }

    public int getCurScore() {
        return this.kbc;
    }

    public a cIT() {
        return this.jZP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jZP.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.kaZ = jSONObject.optInt("is_on");
                this.kba = jSONObject.optInt("is_filter");
                this.kbb = jSONObject.optInt("sign_day_count");
                this.kbc = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
