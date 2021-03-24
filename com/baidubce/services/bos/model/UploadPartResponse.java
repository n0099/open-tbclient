package com.baidubce.services.bos.model;
/* loaded from: classes5.dex */
public class UploadPartResponse {
    public Long crc32;
    public String eTag;
    public int partNumber;

    public Long getCrc32() {
        return this.crc32;
    }

    public String getETag() {
        return this.eTag;
    }

    public PartETag getPartETag() {
        return new PartETag(this.partNumber, this.eTag);
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }
}
