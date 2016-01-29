package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a dNd = new a();
    private int dOm;
    private int dOn;
    private int dOo;
    private int dOp;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aJl() {
        return this.dOo;
    }

    public int getCurScore() {
        return this.dOp;
    }

    public a aIJ() {
        return this.dNd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dNd.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.dOm = jSONObject.optInt("is_on");
                this.dOn = jSONObject.optInt("is_filter");
                this.dOo = jSONObject.optInt("sign_day_count");
                this.dOp = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
