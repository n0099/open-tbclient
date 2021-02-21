package com.baidu.tieba.pbextra.praise;
/* loaded from: classes2.dex */
public class a {
    private String gwT;
    private String mPortrait;
    private String mUserId;
    private String mUserName;
    private long mrD;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.gwT = null;
        this.mrD = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.gwT = str4;
        this.mrD = j;
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
        return this.gwT;
    }

    public long dwk() {
        return this.mrD;
    }
}
