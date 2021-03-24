package com.baidubce.services.bos.model;
/* loaded from: classes5.dex */
public class PutObjectResponse {
    public Long crc32;
    public String eTag;

    public Long getCrc32() {
        return this.crc32;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setETag(String str) {
        this.eTag = str;
    }
}
