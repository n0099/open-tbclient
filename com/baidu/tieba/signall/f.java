package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public String bWv;
    public String iZs;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iZs = jSONObject.optString("banner_pic");
                this.bWv = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
