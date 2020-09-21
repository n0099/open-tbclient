package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
/* loaded from: classes24.dex */
public class ProcessMediaResponse extends AbstractBceResponse {
    private String mediaId;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProcessMediaResponse {");
        sb.append("mediaId='").append(this.mediaId).append('\'');
        sb.append("}\n");
        return sb.toString();
    }
}
