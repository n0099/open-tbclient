package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes5.dex */
public class GetBucketAclRequest extends GenericBucketRequest {
    public GetBucketAclRequest(String str) {
        super(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GetBucketAclRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public GetBucketAclRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
