package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes6.dex */
public class CreateBucketRequest extends GenericBucketRequest {
    public CreateBucketRequest(String str) {
        super(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CreateBucketRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public CreateBucketRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
