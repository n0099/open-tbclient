package com.baidubce.services.bos.model;

import com.baidubce.BceResponseMetadata;
/* loaded from: classes6.dex */
public class BosResponseMetadata extends BceResponseMetadata {
    private String debugId;
    private Long nextAppendOffset;

    public String getBosDebugId() {
        return this.debugId;
    }

    public void setBosDebugId(String str) {
        this.debugId = str;
    }

    public Long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public void setNextAppendOffset(Long l) {
        this.nextAppendOffset = l;
    }
}
