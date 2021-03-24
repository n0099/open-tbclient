package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
/* loaded from: classes5.dex */
public abstract class GenericUploadRequest extends GenericObjectRequest {
    public String uploadId;

    public GenericUploadRequest() {
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        CheckUtils.isNotNull(str, "uploadId should not be null.");
        this.uploadId = str;
    }

    public abstract GenericUploadRequest withUploadId(String str);

    public GenericUploadRequest(String str, String str2, String str3) {
        super(str, str2);
        setUploadId(str3);
    }
}
