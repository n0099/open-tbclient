package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String crp;
    private long ghi;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.crp = null;
        this.ghi = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.crp = str4;
        this.ghi = j;
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

    public String bio() {
        return this.crp;
    }

    public long bip() {
        return this.ghi;
    }
}
