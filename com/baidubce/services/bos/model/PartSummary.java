package com.baidubce.services.bos.model;

import java.util.Date;
/* loaded from: classes6.dex */
public class PartSummary {
    public String eTag;
    public Date lastModified;
    public int partNumber;
    public long size;

    public String getETag() {
        return this.eTag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getSize() {
        return this.size;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setPartNumber(int i2) {
        this.partNumber = i2;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
