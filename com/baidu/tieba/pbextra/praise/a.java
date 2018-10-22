package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String chW;
    private long ghe;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.chW = null;
        this.ghe = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.chW = str4;
        this.ghe = j;
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

    public String bmU() {
        return this.chW;
    }

    public long bmV() {
        return this.ghe;
    }
}
