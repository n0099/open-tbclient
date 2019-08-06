package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public String bEW;
    public String iXW;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iXW = jSONObject.optString("banner_pic");
                this.bEW = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
