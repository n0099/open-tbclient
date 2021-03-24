package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes5.dex */
public final class n implements Serializable {
    public String H;
    public String V;
    public String W;
    public String Y;
    public int id;

    public final void A(String str) {
        this.Y = str;
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

    public final String P() {
        return this.Y;
    }

    public final void setStartTime(String str) {
        this.V = str;
    }

    public final String toString() {
        return "SessionEntity{id=" + this.id + ", startTime='" + this.V + "', keepTime='" + this.Y + "', endTime='" + this.W + "', sessionId='" + this.H + "'}";
    }

    public final void x(String str) {
        this.H = str;
    }

    public final void z(String str) {
        this.W = str;
    }
}
