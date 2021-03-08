package com.baidubce.services.bos.model;
/* loaded from: classes4.dex */
public class GetObjectResponse extends BosResponse {
    private BosObject object;

    public BosObject getObject() {
        return this.object;
    }

    public void setObject(BosObject bosObject) {
        this.object = bosObject;
    }
}
