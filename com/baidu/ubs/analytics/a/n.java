package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes17.dex */
public final class n implements Serializable {
    private String H;
    private String V;
    private String W;
    private String Y;
    private int id;

    public final String N() {
        return this.V;
    }

    public final void setStartTime(String str) {
        this.V = str;
    }

    public final String P() {
        return this.Y;
    }

    public final void A(String str) {
        this.Y = str;
    }

    public final String O() {
        return this.W;
    }

    public final void z(String str) {
        this.W = str;
    }

    public final String I() {
        return this.H;
    }

    public final void x(String str) {
        this.H = str;
    }

    public final String toString() {
        return "SessionEntity{id=" + this.id + ", startTime='" + this.V + "', keepTime='" + this.Y + "', endTime='" + this.W + "', sessionId='" + this.H + "'}";
    }
}
