package com.baidu.tieba.img.effects;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageOperation implements Serializable {
    public String actionName;
    public String actionParam;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.actionName = jSONObject.optString("actionName");
            this.actionParam = jSONObject.optString("actionParam");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionName", this.actionName);
            jSONObject.put("actionParam", this.actionParam);
            return jSONObject;
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return null;
        }
    }
}
