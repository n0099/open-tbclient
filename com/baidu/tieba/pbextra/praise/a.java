package com.baidu.tieba.pbextra.praise;
/* loaded from: classes7.dex */
public class a {
    private long jdY;
    private String mPortrait;
    private String mShowName;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.mShowName = null;
        this.jdY = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.mShowName = str4;
        this.jdY = j;
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
        return this.mShowName;
    }

    public long ctq() {
        return this.jdY;
    }
}
