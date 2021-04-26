package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes5.dex */
public final class i implements Serializable {
    public String H;
    public String I;
    public String T;
    public int id;
    public String type;
    public String url;

    public final String F() {
        return this.I;
    }

    public final String I() {
        return this.H;
    }

    public final String M() {
        return this.T;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setParameters(String str) {
        this.T = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return "NetLogEntity{id=" + this.id + ", url='" + this.url + "', timeStamp='" + this.I + "', parameters='" + this.T + "', type='" + this.type + "', sessionId='" + this.H + "'}";
    }

    public final void u(String str) {
        this.I = str;
    }

    public final void x(String str) {
        this.H = str;
    }
}
