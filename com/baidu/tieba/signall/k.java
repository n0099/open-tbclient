package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k {
    public String jaL;
    public String link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jaL = jSONObject.optString("banner");
                this.link = jSONObject.optString("link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
