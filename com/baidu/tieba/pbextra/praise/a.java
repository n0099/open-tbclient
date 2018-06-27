package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String bSN;
    private long fSj;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.bSN = null;
        this.fSj = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.bSN = str4;
        this.fSj = j;
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

    public String biU() {
        return this.bSN;
    }

    public long biV() {
        return this.fSj;
    }
}
