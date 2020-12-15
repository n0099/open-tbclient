package com.baidu.tieba.pbextra.praise;
/* loaded from: classes22.dex */
public class a {
    private String gof;
    private String mPortrait;
    private String mUserId;
    private String mUserName;
    private long mhI;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.gof = null;
        this.mhI = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.gof = str4;
        this.mhI = j;
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
        return this.gof;
    }

    public long dxW() {
        return this.mhI;
    }
}
