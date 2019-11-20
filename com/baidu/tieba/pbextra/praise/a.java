package com.baidu.tieba.pbextra.praise;
/* loaded from: classes4.dex */
public class a {
    private String eez;
    private long iiz;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.eez = null;
        this.iiz = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.eez = str4;
        this.iiz = j;
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
        return this.eez;
    }

    public long bYQ() {
        return this.iiz;
    }
}
