package com.baidubce.services.bos.model;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.Date;
/* loaded from: classes6.dex */
public class BucketSummary {
    public Date creationDate;
    public String location;
    public String name;

    public BucketSummary() {
        this.name = null;
        this.creationDate = null;
        this.location = null;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "Bucket [name=" + this.name + ", creationDate=" + this.creationDate + PreferencesUtil.RIGHT_MOUNT;
    }

    public BucketSummary(String str, String str2) {
        this.name = null;
        this.creationDate = null;
        this.location = null;
        this.name = str;
        this.location = str2;
    }
}
