package com.baidu.tieba.pbextra.praise;
/* loaded from: classes2.dex */
public class a {
    private String gyC;
    private String mPortrait;
    private String mUserId;
    private String mUserName;
    private long mtG;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.gyC = null;
        this.mtG = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.gyC = str4;
        this.mtG = j;
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
        return this.gyC;
    }

    public long dwt() {
        return this.mtG;
    }
}
