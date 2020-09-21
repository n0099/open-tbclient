package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes24.dex */
public class DoesBucketExistRequest extends GenericBucketRequest {
    public DoesBucketExistRequest(String str) {
        super(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public DoesBucketExistRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public DoesBucketExistRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
