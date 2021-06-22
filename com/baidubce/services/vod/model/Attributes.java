package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class Attributes {
    public String description;
    public String sourceExtension;
    public String title;

    public static Attributes formatFromJson(JSONObject jSONObject) throws JSONException {
        Attributes attributes = new Attributes();
        attributes.setTitle(jSONObject.optString("title"));
        attributes.setDescription(jSONObject.optString("description"));
        return attributes;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Attributes { \n      title = " + this.title + "\n      description = " + this.description + "\n      sourceExtension = " + this.sourceExtension + "\n    }";
    }
}
