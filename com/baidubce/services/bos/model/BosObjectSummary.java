package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.Date;
/* loaded from: classes5.dex */
public class BosObjectSummary {
    public String bucketName;
    public String eTag;
    public String key;
    public Date lastModified;
    public User owner;
    public long size;
    public String storageClass;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public User getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public String toString() {
        return "BosObjectSummary [\n  bucketName=" + this.bucketName + ", \n  key=" + this.key + ", \n  eTag=" + this.eTag + ", \n  size=" + this.size + ", \n  lastModified=" + this.lastModified + ", \n  owner=" + this.owner + ", \n  storageClass=" + this.storageClass + "\n]";
    }
}
