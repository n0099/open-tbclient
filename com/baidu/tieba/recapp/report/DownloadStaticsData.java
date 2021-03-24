package com.baidu.tieba.recapp.report;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class DownloadStaticsData implements Serializable {
    public static final String DOWNLOAD_CONTINUE = "1";
    public static final String DOWNLOAD_NORMAL_CLICK = "0";
    public static final String DOWNLOAD_NOTIFY_CLICK = "1";
    public static final String DOWNLOAD_START = "0";
    public String adPosition;
    public String apk_name;
    public String da_page;
    public String da_range = "0";
    public String da_range_nt = "0";
    public String extensionInfo;
    public String fid;
    public String price;

    public String getAdPosition() {
        return this.adPosition;
    }

    public String getApk_name() {
        return this.apk_name;
    }

    public String getDa_page() {
        return this.da_page;
    }

    public String getDa_range() {
        return this.da_range;
    }

    public String getDa_range_nt() {
        return this.da_range_nt;
    }

    public String getExtensionInfo() {
        return this.extensionInfo;
    }

    public String getFid() {
        return this.fid;
    }

    public String getPrice() {
        return this.price;
    }

    public void setAdPosition(String str) {
        this.adPosition = str;
    }

    public void setApk_name(String str) {
        this.apk_name = str;
    }

    public void setDa_page(String str) {
        this.da_page = str;
    }

    public void setDa_range(String str) {
        this.da_range = str;
    }

    public void setDa_range_nt(String str) {
        this.da_range_nt = str;
    }

    public void setExtensionInfo(String str) {
        this.extensionInfo = str;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }
}
