package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class UploadPartRequest extends GenericUploadRequest {
    public Long crc32;
    public InputStream inputStream;
    public String md5Digest;
    public int partNumber;
    public long partSize;
    public BosProgressCallback progressCallback;

    public UploadPartRequest() {
        this.progressCallback = null;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setInputStream(InputStream inputStream) {
        CheckUtils.isNotNull(inputStream, "inputStream should not be null.");
        this.inputStream = inputStream;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public void setPartNumber(int i2) {
        CheckUtils.checkArgument(i2 > 0, "partNumber should be positive, but is %s", Integer.valueOf(i2));
        this.partNumber = i2;
    }

    public void setPartSize(long j) {
        CheckUtils.checkArgument(j >= 0, "partSize should not be negative.");
        this.partSize = j;
    }

    public <T extends UploadPartRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
    }

    public UploadPartRequest withCrc32(Long l) {
        setCrc32(l);
        return this;
    }

    public UploadPartRequest withInputStream(InputStream inputStream) {
        setInputStream(inputStream);
        return this;
    }

    public UploadPartRequest withMD5Digest(String str) {
        setMd5Digest(str);
        return this;
    }

    public UploadPartRequest withPartNumber(int i2) {
        setPartNumber(i2);
        return this;
    }

    public UploadPartRequest withPartSize(long j) {
        setPartSize(j);
        return this;
    }

    public <T extends UploadPartRequest> UploadPartRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public UploadPartRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public UploadPartRequest withKey(String str) {
        setKey(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public UploadPartRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericUploadRequest
    public UploadPartRequest withUploadId(String str) {
        setUploadId(str);
        return this;
    }

    public UploadPartRequest(String str, String str2, String str3, int i2, long j, InputStream inputStream) {
        super(str, str2, str3);
        this.progressCallback = null;
        setPartNumber(i2);
        setPartSize(j);
        setInputStream(inputStream);
    }
}
