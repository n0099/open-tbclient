package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ProcessMediaRequest extends VodBceRequest {
    public String description;
    public String mediaId;
    public String sourceExtension;
    public String title;
    public String transcodingPresetGroupName;

    public String getDescription() {
        return this.description;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getSourceExtension() {
        return this.sourceExtension;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTranscodingPresetGroupName() {
        return this.transcodingPresetGroupName;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setSourceExtension(String str) {
        this.sourceExtension = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ProcessMediaRequest { \n  mediaId = " + this.mediaId + "\n  title = " + this.title + "\n  description = " + this.description + "\n  sourceExtension = " + this.sourceExtension + "\n}\n";
    }

    public ProcessMediaRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ProcessMediaRequest withMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    @Override // com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public ProcessMediaRequest withSourceExtension(String str) {
        this.sourceExtension = str;
        return this;
    }

    public ProcessMediaRequest withTitle(String str) {
        this.title = str;
        return this;
    }

    public ProcessMediaRequest withTranscodingPresetGroupName(String str) {
        this.transcodingPresetGroupName = str;
        return this;
    }
}
