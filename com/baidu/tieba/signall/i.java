package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ixC = new a();
    private int iyL;
    private int iyM;
    private int iyN;
    private int iyO;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int ccs() {
        return this.signed;
    }

    public int cct() {
        return this.iyN;
    }

    public int getCurScore() {
        return this.iyO;
    }

    public a cbO() {
        return this.ixC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ixC.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iyL = jSONObject.optInt("is_on");
                this.iyM = jSONObject.optInt("is_filter");
                this.iyN = jSONObject.optInt("sign_day_count");
                this.iyO = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
