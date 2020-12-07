package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
/* loaded from: classes25.dex */
public class CopyObjectRequest extends GenericObjectRequest {
    private String eTag;
    private String modifiedSinceConstraint;
    private ObjectMetadata newObjectMetadata;
    private String noneMatchETagConstraint;
    private String sourceBucketName;
    private String sourceKey;
    private String storageClass;
    private String unmodifiedSinceConstraint;

    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        super(str3, str4);
        this.newObjectMetadata = null;
        setSourceBucketName(str);
        setSourceKey(str2);
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public void setSourceBucketName(String str) {
        CheckUtils.isNotNull(str, "sourceBucketName should not be null");
        this.sourceBucketName = str;
    }

    public CopyObjectRequest withSourceBucketName(String str) {
        setSourceBucketName(str);
        return this;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public void setSourceKey(String str) {
        CheckUtils.isNotNull(str, "sourceKey should not be null");
        this.sourceKey = str;
    }

    public CopyObjectRequest withSourceKey(String str) {
        setSourceKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public CopyObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
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

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public CopyObjectRequest withNewObjectMetadata(ObjectMetadata objectMetadata) {
        setNewObjectMetadata(objectMetadata);
        return this;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public CopyObjectRequest withETag(String str) {
        setETag(str);
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public CopyObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public String getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setUnmodifiedSinceConstraint(String str) {
        this.unmodifiedSinceConstraint = str;
    }

    public CopyObjectRequest withUnmodifiedSinceConstraint(String str) {
        setUnmodifiedSinceConstraint(str);
        return this;
    }

    public String getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public void setModifiedSinceConstraint(String str) {
        this.modifiedSinceConstraint = str;
    }

    public CopyObjectRequest withModifiedSinceConstraint(String str) {
        setModifiedSinceConstraint(str);
        return this;
    }

    public String getNoneMatchETagConstraint() {
        return this.noneMatchETagConstraint;
    }

    public void setNoneMatchETagConstraint(String str) {
        this.noneMatchETagConstraint = str;
    }

    public CopyObjectRequest withNoMatchingETagConstraint(String str) {
        setNoneMatchETagConstraint(str);
        return this;
    }
}
