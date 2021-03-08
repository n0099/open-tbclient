package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes4.dex */
public class DeleteBucketRequest extends GenericBucketRequest {
    public DeleteBucketRequest(String str) {
        super(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public DeleteBucketRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public DeleteBucketRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
