package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String bZw;
    private long fZC;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.bZw = null;
        this.fZC = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.bZw = str4;
        this.fZC = j;
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

    public String bjJ() {
        return this.bZw;
    }

    public long bjK() {
        return this.fZC;
    }
}
