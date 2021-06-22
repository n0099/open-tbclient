package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class AppendObjectRequest extends PutObjectRequest {
    public Long offset;

    public AppendObjectRequest(String str, String str2, File file) {
        this(str, str2, file, null, new ObjectMetadata());
        CheckUtils.isNotNull(file, "file should not be null.");
    }

    public Long getOffset() {
        return this.offset;
    }

    public void setOffset(Long l) {
        this.offset = l;
    }

    public AppendObjectRequest withOffset(Long l) {
        setOffset(l);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest
    public AppendObjectRequest withFile(File file) {
        setFile(file);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest
    public AppendObjectRequest withInputStream(InputStream inputStream) {
        setInputStream(inputStream);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest
    public AppendObjectRequest withObjectMetadata(ObjectMetadata objectMetadata) {
        setObjectMetadata(objectMetadata);
        return this;
    }

    public AppendObjectRequest(String str, String str2, File file, ObjectMetadata objectMetadata) {
        this(str, str2, file, null, objectMetadata);
        CheckUtils.isNotNull(file, "file should not be null.");
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest, com.baidubce.services.bos.model.GenericBucketRequest
    public AppendObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest, com.baidubce.services.bos.model.GenericObjectRequest
    public AppendObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.PutObjectRequest, com.baidubce.model.AbstractBceRequest
    public AppendObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public AppendObjectRequest(String str, String str2, InputStream inputStream) {
        this(str, str2, null, inputStream, new ObjectMetadata());
        CheckUtils.isNotNull(inputStream, "inputStream should not be null.");
    }

    public AppendObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        this(str, str2, null, inputStream, objectMetadata);
        CheckUtils.isNotNull(inputStream, "inputStream should not be null.");
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
    }

    public AppendObjectRequest(String str, String str2, File file, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, file, inputStream, objectMetadata);
    }
}
