package com.baidubce.services.bos.model;
/* loaded from: classes5.dex */
public class CompleteMultipartUploadResponse extends BosResponse {
    public String bucketName;
    public Long crc32;
    public String eTag;
    public String key;
    public String location;

    public String getBucketName() {
        return this.bucketName;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public String getLocation() {
        return this.location;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }
}
