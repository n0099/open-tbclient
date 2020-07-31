package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.Date;
/* loaded from: classes19.dex */
public class MultipartUploadSummary {
    private Date initiated;
    private String key;
    private User owner;
    private String storageClass;
    private String uploadId;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public Date getInitiated() {
        return this.initiated;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }
}
