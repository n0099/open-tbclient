package com.baidu.tieba.pbextra.praise;
/* loaded from: classes4.dex */
public class a {
    private String dBi;
    private long hJj;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.dBi = null;
        this.hJj = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.dBi = str4;
        this.hJj = j;
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
        return this.dBi;
    }

    public long bPY() {
        return this.hJj;
    }
}
