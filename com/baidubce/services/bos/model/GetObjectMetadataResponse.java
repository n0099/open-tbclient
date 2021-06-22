package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class GetObjectMetadataResponse extends BosResponse {
    public ObjectMetadata objectMetadata = new ObjectMetadata();

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.objectMetadata = objectMetadata;
    }
}
