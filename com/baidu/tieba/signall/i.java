package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iWx = new a();
    private int iXG;
    private int iXH;
    private int iXI;
    private int iXJ;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cnn() {
        return this.signed;
    }

    public int cno() {
        return this.iXI;
    }

    public int getCurScore() {
        return this.iXJ;
    }

    public a cmJ() {
        return this.iWx;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iWx.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iXG = jSONObject.optInt("is_on");
                this.iXH = jSONObject.optInt("is_filter");
                this.iXI = jSONObject.optInt("sign_day_count");
                this.iXJ = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
