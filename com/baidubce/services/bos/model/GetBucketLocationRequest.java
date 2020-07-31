package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes19.dex */
public class GetBucketLocationRequest extends GenericBucketRequest {
    public GetBucketLocationRequest(String str) {
        super(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GetBucketLocationRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public GetBucketLocationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
