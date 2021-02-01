package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    public String link;
    public String npb;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.npb = jSONObject.optString("banner");
                this.link = jSONObject.optString("link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
