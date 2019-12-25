package com.baidu.tieba.pbextra.praise;
/* loaded from: classes6.dex */
public class a {
    private String eUu;
    private long jav;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.eUu = null;
        this.jav = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.eUu = str4;
        this.jav = j;
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
        return this.eUu;
    }

    public long csj() {
        return this.jav;
    }
}
