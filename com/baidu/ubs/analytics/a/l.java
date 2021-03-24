package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes5.dex */
public final class l implements Serializable {
    public String H;
    public String J;
    public String V;
    public String W;
    public int id;
    public String path;

    public final String E() {
        return this.J;
    }

    public final String I() {
        return this.H;
    }

    public final String N() {
        return this.V;
    }

    public final String O() {
        return this.W;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void setStartTime(String str) {
        this.V = str;
    }

    public final void t(String str) {
        this.J = str;
    }

    public final String toString() {
        return "PagerLogEntity{id=" + this.id + ", pagerName='" + this.J + "', startTime='" + this.V + "', endTime='" + this.W + "', path='" + this.path + "', sessionId='" + this.H + "'}";
    }

    public final void x(String str) {
        this.H = str;
    }

    public final void z(String str) {
        this.W = str;
    }
}
