package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public String Sc;
    public String efY;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.efY = jSONObject.optString("banner_pic");
                this.Sc = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
