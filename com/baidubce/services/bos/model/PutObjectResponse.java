package com.baidubce.services.bos.model;
/* loaded from: classes5.dex */
public class PutObjectResponse {
    private Long crc32;
    private String eTag;

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }
}
