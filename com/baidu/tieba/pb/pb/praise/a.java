package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private String dnL;
    private long dnM;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.dnL = null;
        this.dnM = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.dnL = str4;
        this.dnM = j;
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

    public String ask() {
        return this.dnL;
    }

    public long azz() {
        return this.dnM;
    }
}
