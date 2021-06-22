package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class AppendObjectResponse extends PutObjectResponse {
    public String contentMd5;
    public Long nextAppendOffset;

    public String getContentMd5() {
        return this.contentMd5;
    }

    public Long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public void setNextAppendOffset(Long l) {
        this.nextAppendOffset = l;
    }
}
