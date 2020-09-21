package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
/* loaded from: classes24.dex */
public abstract class GenericUploadRequest extends GenericObjectRequest {
    private String uploadId;

    public abstract GenericUploadRequest withUploadId(String str);

    public GenericUploadRequest() {
    }

    public GenericUploadRequest(String str, String str2, String str3) {
        super(str, str2);
        setUploadId(str3);
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        CheckUtils.isNotNull(str, "uploadId should not be null.");
        this.uploadId = str;
    }
}
