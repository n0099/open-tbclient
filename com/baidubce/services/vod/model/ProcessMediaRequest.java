package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class ProcessMediaRequest extends VodBceRequest {
    private String description;
    private String mediaId;
    private String sourceExtension;
    private String title;
    private String transcodingPresetGroupName;

    public String toString() {
        StringBuilder sb = new StringBuilder("ProcessMediaRequest { \n");
        sb.append("  mediaId = ").append(this.mediaId).append("\n");
        sb.append("  title = ").append(this.title).append("\n");
        sb.append("  description = ").append(this.description).append("\n");
        sb.append("  sourceExtension = ").append(this.sourceExtension).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public ProcessMediaRequest withMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public ProcessMediaRequest withTitle(String str) {
        this.title = str;
        return this;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
    }

    public ProcessMediaRequest withTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public ProcessMediaRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public ProcessMediaRequest withSourceExtension(String str) {
        this.sourceExtension = str;
        return this;
    }

    @Override // com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    @Override // com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mediaId", this.mediaId);
            jSONObject.put("title", this.title);
            jSONObject.put("description", this.description);
            jSONObject.put("sourceExtension", this.sourceExtension);
            jSONObject.put("transcodingPresetGroupName", this.transcodingPresetGroupName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
