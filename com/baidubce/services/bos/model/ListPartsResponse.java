package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class ListPartsResponse extends BosResponse {
    private String bucketName;
    private Date initiated;
    private boolean isTruncated;
    private String key;
    private Integer maxParts;
    private int nextPartNumberMarker;
    private User owner;
    private int partNumberMarker;
    private List<PartSummary> parts;
    private String storageClass;
    private String uploadId;

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

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = i;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public void setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public List<PartSummary> getParts() {
        if (this.parts == null) {
            this.parts = new ArrayList();
        }
        return this.parts;
    }

    public void setParts(List<PartSummary> list) {
        this.parts = list;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }
}
