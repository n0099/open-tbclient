package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.Date;
/* loaded from: classes5.dex */
public class MultipartUploadSummary {
    public Date initiated;
    public String key;
    public User owner;
    public String storageClass;
    public String uploadId;

    public Date getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public User getOwner() {
        return this.owner;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
