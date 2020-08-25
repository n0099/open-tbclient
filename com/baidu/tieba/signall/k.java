package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class k {
    public String lXs;
    public String link;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lXs = jSONObject.optString("banner");
                this.link = jSONObject.optString("link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
