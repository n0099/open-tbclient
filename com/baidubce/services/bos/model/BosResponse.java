package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceResponse;
/* loaded from: classes5.dex */
public class BosResponse extends AbstractBceResponse {
    public BosResponse() {
        this.metadata = new BosResponseMetadata();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceResponse
    public BosResponseMetadata getMetadata() {
        return (BosResponseMetadata) this.metadata;
    }
}
