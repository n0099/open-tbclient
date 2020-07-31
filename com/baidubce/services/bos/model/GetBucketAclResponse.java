package com.baidubce.services.bos.model;

import java.util.List;
/* loaded from: classes19.dex */
public class GetBucketAclResponse extends BosResponse {
    public static final int MAX_SUPPORTED_ACL_VERSION = 1;
    private List<Grant> accessControlList;
    private Grantee owner;
    private int version = 1;

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public Grantee getOwner() {
        return this.owner;
    }

    public void setOwner(Grantee grantee) {
        this.owner = grantee;
    }

    public List<Grant> getAccessControlList() {
        return this.accessControlList;
    }

    public void setAccessControlList(List<Grant> list) {
        this.accessControlList = list;
    }
}
