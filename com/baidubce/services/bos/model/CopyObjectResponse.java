package com.baidubce.services.bos.model;

import java.util.Date;
/* loaded from: classes24.dex */
public class CopyObjectResponse extends BosResponse {
    private String eTag;
    private Date lastModified;

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }
}
