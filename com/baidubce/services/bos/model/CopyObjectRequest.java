package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
/* loaded from: classes5.dex */
public class CopyObjectRequest extends GenericObjectRequest {
    public String eTag;
    public String modifiedSinceConstraint;
    public ObjectMetadata newObjectMetadata;
    public String noneMatchETagConstraint;
    public String sourceBucketName;
    public String sourceKey;
    public String storageClass;
    public String unmodifiedSinceConstraint;

    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        super(str3, str4);
        this.newObjectMetadata = null;
        setSourceBucketName(str);
        setSourceKey(str2);
    }

    public String getETag() {
        return this.eTag;
    }

    public String getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public String getNoneMatchETagConstraint() {
        return this.noneMatchETagConstraint;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setModifiedSinceConstraint(String str) {
        this.modifiedSinceConstraint = str;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public void setNoneMatchETagConstraint(String str) {
        this.noneMatchETagConstraint = str;
    }

    public void setSourceBucketName(String str) {
        CheckUtils.isNotNull(str, "sourceBucketName should not be null");
        this.sourceBucketName = str;
    }

    public void setSourceKey(String str) {
        CheckUtils.isNotNull(str, "sourceKey should not be null");
        this.sourceKey = str;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setUnmodifiedSinceConstraint(String str) {
        this.unmodifiedSinceConstraint = str;
    }

    public CopyObjectRequest withETag(String str) {
        setETag(str);
        return this;
    }

    public CopyObjectRequest withModifiedSinceConstraint(String str) {
        setModifiedSinceConstraint(str);
        return this;
    }

    public CopyObjectRequest withNewObjectMetadata(ObjectMetadata objectMetadata) {
        setNewObjectMetadata(objectMetadata);
        return this;
    }

    public CopyObjectRequest withNoMatchingETagConstraint(String str) {
        setNoneMatchETagConstraint(str);
        return this;
    }

    public CopyObjectRequest withSourceBucketName(String str) {
        setSourceBucketName(str);
        return this;
    }

    public CopyObjectRequest withSourceKey(String str) {
        setSourceKey(str);
        return this;
    }

    public CopyObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public CopyObjectRequest withUnmodifiedSinceConstraint(String str) {
        setUnmodifiedSinceConstraint(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public CopyObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public CopyObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CopyObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
