package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a hbJ = new a();
    private int hcS;
    private int hcT;
    private int hcU;
    private int hcV;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bAc() {
        return this.signed;
    }

    public int bAd() {
        return this.hcU;
    }

    public int getCurScore() {
        return this.hcV;
    }

    public a bzy() {
        return this.hbJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hbJ.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.hcS = jSONObject.optInt("is_on");
                this.hcT = jSONObject.optInt("is_filter");
                this.hcU = jSONObject.optInt("sign_day_count");
                this.hcV = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
