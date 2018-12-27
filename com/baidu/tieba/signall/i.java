package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a heN = new a();
    private int hfW;
    private int hfX;
    private int hfY;
    private int hfZ;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bAS() {
        return this.signed;
    }

    public int bAT() {
        return this.hfY;
    }

    public int getCurScore() {
        return this.hfZ;
    }

    public a bAo() {
        return this.heN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.heN.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.hfW = jSONObject.optInt("is_on");
                this.hfX = jSONObject.optInt("is_filter");
                this.hfY = jSONObject.optInt("sign_day_count");
                this.hfZ = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
