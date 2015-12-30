package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private long cKA;
    private String cKz;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.cKz = null;
        this.cKA = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.cKz = str4;
        this.cKA = j;
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

    public String ahw() {
        return this.cKz;
    }

    public long anq() {
        return this.cKA;
    }
}
