package com.baidu.tieba.pb.a;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int cJq;
    private String cJr;
    private String cJs;
    private String mLink;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cJq = jSONObject.optInt("draw_res_type");
                this.mLink = jSONObject.optString("link");
                this.cJr = jSONObject.optString("award_imgsrc");
                this.cJs = jSONObject.optString("award_des");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String getLink() {
        return this.mLink;
    }

    public String aoA() {
        return this.cJr;
    }

    public String aoB() {
        return this.cJs;
    }
}
