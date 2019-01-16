package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a hfR = new a();
    private int hha;
    private int hhb;
    private int hhc;
    private int hhd;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bBB() {
        return this.signed;
    }

    public int bBC() {
        return this.hhc;
    }

    public int getCurScore() {
        return this.hhd;
    }

    public a bAX() {
        return this.hfR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hfR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.hha = jSONObject.optInt("is_on");
                this.hhb = jSONObject.optInt("is_filter");
                this.hhc = jSONObject.optInt("sign_day_count");
                this.hhd = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
