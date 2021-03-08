package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;
/* loaded from: classes4.dex */
public class GetObjectRequest extends GenericObjectRequest {
    private BosProgressCallback progressCallback;
    private long[] range;

    public GetObjectRequest() {
        this.progressCallback = null;
    }

    public GetObjectRequest(String str, String str2) {
        super(str, str2);
        this.progressCallback = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.model.AbstractBceRequest
    public GetObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericBucketRequest
    public GetObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidubce.services.bos.model.GenericObjectRequest
    public GetObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public long[] getRange() {
        if (this.range == null) {
            return null;
        }
        return (long[]) this.range.clone();
    }

    public void setRange(long j, long j2) {
        CheckUtils.checkArgument(j >= 0, "start should be non-negative.");
        CheckUtils.checkArgument(j <= j2, "start should not be greater than end");
        this.range = new long[]{j, j2};
    }

    public GetObjectRequest withRange(long j, long j2) {
        setRange(j, j2);
        return this;
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public <T extends GetObjectRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
    }

    public <T extends GetObjectRequest> GetObjectRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
        return this;
    }
}
