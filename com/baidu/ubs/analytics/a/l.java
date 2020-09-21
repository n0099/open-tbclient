package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes7.dex */
public final class l implements Serializable {
    private String H;
    private String J;
    private String V;
    private String W;
    private int id;
    private String path;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String E() {
        return this.J;
    }

    public final void t(String str) {
        this.J = str;
    }

    public final String N() {
        return this.V;
    }

    public final void setStartTime(String str) {
        this.V = str;
    }

    public final String O() {
        return this.W;
    }

    public final void z(String str) {
        this.W = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final String I() {
        return this.H;
    }

    public final void x(String str) {
        this.H = str;
    }

    public final String toString() {
        return "PagerLogEntity{id=" + this.id + ", pagerName='" + this.J + "', startTime='" + this.V + "', endTime='" + this.W + "', path='" + this.path + "', sessionId='" + this.H + "'}";
    }
}
