package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iZW = new a();
    private int jbf;
    private int jbg;
    private int jbh;
    private int jbi;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cos() {
        return this.signed;
    }

    public int cot() {
        return this.jbh;
    }

    public int getCurScore() {
        return this.jbi;
    }

    public a cnO() {
        return this.iZW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iZW.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jbf = jSONObject.optInt("is_on");
                this.jbg = jSONObject.optInt("is_filter");
                this.jbh = jSONObject.optInt("sign_day_count");
                this.jbi = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
