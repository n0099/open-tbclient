package com.baidubce.services.bos.model;
/* loaded from: classes4.dex */
public class AppendObjectResponse extends PutObjectResponse {
    private String contentMd5;
    private Long nextAppendOffset;

    public String getContentMd5() {
        return this.contentMd5;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public Long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public void setNextAppendOffset(Long l) {
        this.nextAppendOffset = l;
    }
}
