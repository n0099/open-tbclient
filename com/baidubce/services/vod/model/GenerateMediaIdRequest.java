package com.baidubce.services.vod.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
/* loaded from: classes19.dex */
public class GenerateMediaIdRequest extends VodBceRequest {
    @Override // com.baidubce.model.AbstractBceRequest
    public AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    @Override // com.baidubce.services.vod.model.VodBceRequest
    public String toJsonString() {
        return "";
    }
}
