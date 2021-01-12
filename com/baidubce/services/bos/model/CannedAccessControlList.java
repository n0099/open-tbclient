package com.baidubce.services.bos.model;

import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes5.dex */
public enum CannedAccessControlList {
    Private(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write");
    
    private final String cannedAclHeader;

    CannedAccessControlList(String str) {
        this.cannedAclHeader = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.cannedAclHeader;
    }
}
