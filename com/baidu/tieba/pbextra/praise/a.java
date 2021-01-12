package com.baidu.tieba.pbextra.praise;
/* loaded from: classes2.dex */
public class a {
    private String gtV;
    private String mPortrait;
    private String mUserId;
    private String mUserName;
    private long mim;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.gtV = null;
        this.mim = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.gtV = str4;
        this.mim = j;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getShowName() {
        return this.gtV;
    }

    public long dtU() {
        return this.mim;
    }
}
