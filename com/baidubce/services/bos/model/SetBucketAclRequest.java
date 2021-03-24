package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import java.util.List;
/* loaded from: classes5.dex */
public class SetBucketAclRequest extends GenericBucketRequest {
    public List<Grant> accessControlList;
    public CannedAccessControlList cannedAcl;

    public SetBucketAclRequest(String str, CannedAccessControlList cannedAccessControlList) {
        super(str);
        setCannedAcl(cannedAccessControlList);
    }

    public List<Grant> getAccessControlList() {
        return this.accessControlList;
    }

    public CannedAccessControlList getCannedAcl() {
        return this.cannedAcl;
    }

    public void setAccessControlList(List<Grant> list) {
        this.accessControlList = list;
    }

    public void setCannedAcl(CannedAccessControlList cannedAccessControlList) {
        this.cannedAcl = cannedAccessControlList;
    }

    public SetBucketAclRequest withAccessControlList(List<Grant> list) {
        setAccessControlList(list);
        return this;
    }

    public SetBucketAclRequest withCannedAcl(CannedAccessControlList cannedAccessControlList) {
        setCannedAcl(cannedAccessControlList);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public SetBucketAclRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public SetBucketAclRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public SetBucketAclRequest(String str, List<Grant> list) {
        super(str);
        setAccessControlList(list);
    }
}
