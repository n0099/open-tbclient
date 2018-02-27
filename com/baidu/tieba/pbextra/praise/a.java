package com.baidu.tieba.pbextra.praise;
/* loaded from: classes3.dex */
public class a {
    private String crd;
    private long ggX;
    private String mPortrait;
    private String mUserId;
    private String mUserName;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.mUserName = null;
        this.mPortrait = null;
        this.crd = null;
        this.ggX = 0L;
        this.mUserId = str;
        this.mUserName = str2;
        this.mPortrait = str3;
        this.crd = str4;
        this.ggX = j;
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

    public String bin() {
        return this.crd;
    }

    public long bio() {
        return this.ggX;
    }
}
