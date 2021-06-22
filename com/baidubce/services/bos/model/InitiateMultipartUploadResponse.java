package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class InitiateMultipartUploadResponse extends BosResponse {
    public String bucketName;
    public String key;
    public String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
