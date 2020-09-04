package com.baidu.tieba.recapp.report;

import java.io.Serializable;
/* loaded from: classes.dex */
public class DownloadStaticsData implements Serializable {
    public static final String DOWNLOAD_CONTINUE = "1";
    public static final String DOWNLOAD_NORMAL_CLICK = "0";
    public static final String DOWNLOAD_NOTIFY_CLICK = "1";
    public static final String DOWNLOAD_START = "0";
    private String adPosition;
    private String apk_name;
    private String da_page;
    private String da_range = "0";
    private String da_range_nt = "0";
    private String extensionInfo;
    private String fid;
    private String price;

    public String getDa_range() {
        return this.da_range;
    }

    public void setDa_range(String str) {
        this.da_range = str;
    }

    public String getDa_page() {
        return this.da_page;
    }

    public void setDa_page(String str) {
        this.da_page = str;
    }

    public String getFid() {
        return this.fid;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public String getApk_name() {
        return this.apk_name;
    }

    public void setApk_name(String str) {
        this.apk_name = str;
    }

    public String getDa_range_nt() {
        return this.da_range_nt;
    }

    public void setDa_range_nt(String str) {
        this.da_range_nt = str;
    }

    public String getAdPosition() {
        return this.adPosition;
    }

    public void setAdPosition(String str) {
        this.adPosition = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getExtensionInfo() {
        return this.extensionInfo;
    }

    public void setExtensionInfo(String str) {
        this.extensionInfo = str;
    }
}
