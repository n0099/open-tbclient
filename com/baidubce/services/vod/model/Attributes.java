package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Attributes {
    private String description;
    private String sourceExtension;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public static Attributes formatFromJson(JSONObject jSONObject) throws JSONException {
        Attributes attributes = new Attributes();
        attributes.setTitle(jSONObject.optString("title"));
        attributes.setDescription(jSONObject.optString("description"));
        return attributes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Attributes { \n");
        sb.append("      title = ").append(this.title).append("\n");
        sb.append("      description = ").append(this.description).append("\n");
        sb.append("      sourceExtension = ").append(this.sourceExtension).append("\n");
        sb.append("    }");
        return sb.toString();
    }
}
