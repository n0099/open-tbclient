package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceResponse;
/* loaded from: classes6.dex */
public class GenerateMediaIdResponse extends AbstractBceResponse {
    public String endPoint;
    public String mediaId;
    public String sourceBucket;
    public String sourceKey;

    public String getEndPoint() {
        return this.endPoint;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getSourceBucket() {
        return this.sourceBucket;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setSourceBucket(String str) {
        this.sourceBucket = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public String toString() {
        return "GenerateMediaIdResponse { \n  mediaId = " + this.mediaId + "\n  sourceBucket = " + this.sourceBucket + "\n  sourceKey = " + this.sourceKey + "\n  endPoint = " + this.endPoint + "\n}\n";
    }
}
