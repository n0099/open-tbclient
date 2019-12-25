package com.baidubce.services.sts.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes.dex */
public class GetSessionTokenRequest extends AbstractBceRequest {
    private String acl;
    private Integer durationSeconds = 43200;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GetSessionTokenRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public GetSessionTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public String getAcl() {
        return this.acl;
    }

    public void setAcl(String str) {
        this.acl = str;
    }

    public GetSessionTokenRequest withAcl(String str) {
        this.acl = str;
        return this;
    }
}
