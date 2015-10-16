package com.baidu.tieba.pb.pb.praise;
/* loaded from: classes.dex */
public class a {
    private String air;
    private String cma;
    private long cmb;
    private String mPortrait;
    private String mUserId;

    public a(String str, String str2, String str3, String str4, long j) {
        this.mUserId = null;
        this.air = null;
        this.mPortrait = null;
        this.cma = null;
        this.cmb = 0L;
        this.mUserId = str;
        this.air = str2;
        this.mPortrait = str3;
        this.cma = str4;
        this.cmb = j;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.air;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String agY() {
        return this.cma;
    }

    public long agZ() {
        return this.cmb;
    }
}
