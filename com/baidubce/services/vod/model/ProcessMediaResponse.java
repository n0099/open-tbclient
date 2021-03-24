package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
/* loaded from: classes5.dex */
public class ProcessMediaResponse extends AbstractBceResponse {
    public String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String toString() {
        return "ProcessMediaResponse {mediaId='" + this.mediaId + "'}\n";
    }
}
