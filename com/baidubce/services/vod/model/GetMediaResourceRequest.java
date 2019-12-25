package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes.dex */
public class GetMediaResourceRequest extends VodBceRequest {
    private String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public GetMediaResourceRequest withMediaId(String str) {
        this.mediaId = str;
        return this;
    }

    @Override // com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetMediaResourceRequest { \n");
        sb.append("  mediaId = ").append(this.mediaId).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override // com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        return "";
    }
}
