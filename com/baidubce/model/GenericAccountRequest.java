package com.baidubce.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes6.dex */
public class GenericAccountRequest extends AbstractBceRequest {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GenericAccountRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
