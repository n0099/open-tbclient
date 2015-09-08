package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private String aju;
    private String cgu;
    private long cgv;
    private String mPortrait;
    private String mUserId;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.aju = null;
        this.mPortrait = null;
        this.cgu = null;
        this.cgv = 0L;
        this.mUserId = str;
        this.aju = str2;
        this.mPortrait = str3;
        this.cgu = str4;
        this.cgv = j;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.aju;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String aeZ() {
        return this.cgu;
    }

    public long afa() {
        return this.cgv;
    }
}
