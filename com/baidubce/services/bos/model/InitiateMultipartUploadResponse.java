package com.baidubce.services.bos.model;
/* loaded from: classes24.dex */
public class InitiateMultipartUploadResponse extends BosResponse {
    private String bucketName;
    private String key;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
