package com.baidubce.services.bos.model;

import java.util.List;
/* loaded from: classes5.dex */
public class GetBucketAclResponse extends BosResponse {
    public static final int MAX_SUPPORTED_ACL_VERSION = 1;
    public List<Grant> accessControlList;
    public Grantee owner;
    public int version = 1;

    public List<Grant> getAccessControlList() {
        return this.accessControlList;
    }

    public Grantee getOwner() {
        return this.owner;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAccessControlList(List<Grant> list) {
        this.accessControlList = list;
    }

    public void setOwner(Grantee grantee) {
        this.owner = grantee;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
