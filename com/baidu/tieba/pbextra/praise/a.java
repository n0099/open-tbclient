package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String bTI;
    private long fSu;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.bTI = null;
        this.fSu = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.bTI = str4;
        this.fSu = j;
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

    public String bhn() {
        return this.bTI;
    }

    public long bho() {
        return this.fSu;
    }
}
