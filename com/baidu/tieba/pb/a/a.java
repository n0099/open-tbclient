package com.baidu.tieba.pb.a;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int cze;
    private String czf;
    private String czg;
    private String mLink;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cze = jSONObject.optInt("draw_res_type");
                this.mLink = jSONObject.optString("link");
                this.czf = jSONObject.optString("award_imgsrc");
                this.czg = jSONObject.optString("award_des");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String getLink() {
        return this.mLink;
    }

    public String aju() {
        return this.czf;
    }

    public String ajv() {
        return this.czg;
    }
}
