package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String cih;
    private long giB;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.cih = null;
        this.giB = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.cih = str4;
        this.giB = j;
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
        return this.cih;
    }

    public long bmq() {
        return this.giB;
    }
}
