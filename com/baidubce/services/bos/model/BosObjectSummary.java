package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.Date;
/* loaded from: classes25.dex */
public class BosObjectSummary {
    protected String bucketName;
    protected String eTag;
    protected String key;
    protected Date lastModified;
    protected User owner;
    protected long size;
    protected String storageClass;

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public String toString() {
        return "BosObjectSummary [\n  bucketName=" + this.bucketName + ", \n  key=" + this.key + ", \n  eTag=" + this.eTag + ", \n  size=" + this.size + ", \n  lastModified=" + this.lastModified + ", \n  owner=" + this.owner + ", \n  storageClass=" + this.storageClass + "\n]";
    }
}
