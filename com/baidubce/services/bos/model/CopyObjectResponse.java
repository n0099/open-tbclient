package com.baidubce.services.bos.model;

import java.util.Date;
/* loaded from: classes5.dex */
public class CopyObjectResponse extends BosResponse {
    public String eTag;
    public Date lastModified;

    public String getETag() {
        return this.eTag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }
}
