package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
/* loaded from: classes.dex */
public class GenerateMediaIdResponse extends AbstractBceResponse {
    private String endPoint;
    private String mediaId;
    private String sourceBucket;
    private String sourceKey;

    public String getMediaId() {
        return this.mediaId;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public String getSourceBucket() {
        return this.sourceBucket;
    }

    public void setSourceBucket(String str) {
        this.sourceBucket = str;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GenerateMediaIdResponse { \n");
        sb.append("  mediaId = ").append(this.mediaId).append("\n");
        sb.append("  sourceBucket = ").append(this.sourceBucket).append("\n");
        sb.append("  sourceKey = ").append(this.sourceKey).append("\n");
        sb.append("  endPoint = ").append(this.endPoint).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
