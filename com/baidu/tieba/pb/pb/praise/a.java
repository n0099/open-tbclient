package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private String aiq;
    private String clP;
    private long clQ;
    private String mPortrait;
    private String mUserId;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.aiq = null;
        this.mPortrait = null;
        this.clP = null;
        this.clQ = 0L;
        this.mUserId = str;
        this.aiq = str2;
        this.mPortrait = str3;
        this.clP = str4;
        this.clQ = j;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.aiq;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String agY() {
        return this.clP;
    }

    public long agZ() {
        return this.clQ;
    }
}
