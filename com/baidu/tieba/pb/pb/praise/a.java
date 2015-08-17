package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private String ajl;
    private String cfx;
    private long cfy;
    private String mPortrait;
    private String mUserId;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.ajl = null;
        this.mPortrait = null;
        this.cfx = null;
        this.cfy = 0L;
        this.mUserId = str;
        this.ajl = str2;
        this.mPortrait = str3;
        this.cfx = str4;
        this.cfy = j;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.ajl;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String aeL() {
        return this.cfx;
    }

    public long aeM() {
        return this.cfy;
    }
}
