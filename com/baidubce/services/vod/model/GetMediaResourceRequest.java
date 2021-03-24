package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes5.dex */
public class GetMediaResourceRequest extends VodBceRequest {
    public String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    @Override // com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        return "";
    }

    public String toString() {
        return "GetMediaResourceRequest { \n  mediaId = " + this.mediaId + "\n}\n";
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
}
