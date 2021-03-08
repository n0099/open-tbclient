package com.baidubce.services.bos.model;

import java.util.Date;
/* loaded from: classes4.dex */
public class BucketSummary {
    private Date creationDate;
    private String location;
    private String name;

    public BucketSummary() {
        this.name = null;
        this.creationDate = null;
        this.location = null;
    }

    public BucketSummary(String str, String str2) {
        this.name = null;
        this.creationDate = null;
        this.location = null;
        this.name = str;
        this.location = str2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public String toString() {
        return "Bucket [name=" + this.name + ", creationDate=" + this.creationDate + "]";
    }
}
