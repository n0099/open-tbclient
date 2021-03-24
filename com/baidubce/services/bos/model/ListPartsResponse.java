package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class ListPartsResponse extends BosResponse {
    public String bucketName;
    public Date initiated;
    public boolean isTruncated;
    public String key;
    public Integer maxParts;
    public int nextPartNumberMarker;
    public User owner;
    public int partNumberMarker;
    public List<PartSummary> parts;
    public String storageClass;
    public String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public Date getInitiated() {
        return this.initiated;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public User getOwner() {
        return this.owner;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public List<PartSummary> getParts() {
        if (this.parts == null) {
            this.parts = new ArrayList();
        }
        return this.parts;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setInitiated(Date date) {
        this.initiated = date;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public void setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = i;
    }

    public void setParts(List<PartSummary> list) {
        this.parts = list;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
