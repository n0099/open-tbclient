package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class GetBucketLocationResponse extends BosResponse {
    public String locationConstraint = "";

    public String getLocationConstraint() {
        return this.locationConstraint;
    }

    public void setLocationConstraint(String str) {
        this.locationConstraint = str;
    }
}
