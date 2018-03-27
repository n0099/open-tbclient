package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String crg;
    private long ghn;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.crg = null;
        this.ghn = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.crg = str4;
        this.ghn = j;
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
        return this.crg;
    }

    public long bip() {
        return this.ghn;
    }
}
