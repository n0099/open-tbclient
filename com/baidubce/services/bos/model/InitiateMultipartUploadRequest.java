package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
/* loaded from: classes5.dex */
public class InitiateMultipartUploadRequest extends GenericObjectRequest {
    public ObjectMetadata objectMetadata;
    public String storageClass;

    public InitiateMultipartUploadRequest(String str, String str2) {
        super(str, str2);
        this.objectMetadata = new ObjectMetadata();
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public InitiateMultipartUploadRequest withMetadata(ObjectMetadata objectMetadata) {
        setObjectMetadata(objectMetadata);
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public InitiateMultipartUploadRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public InitiateMultipartUploadRequest withKey(String str) {
        setKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public InitiateMultipartUploadRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
