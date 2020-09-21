package com.baidu.ubs.analytics.a;

import java.io.Serializable;
/* loaded from: classes7.dex */
public final class i implements Serializable {
    private String H;
    private String I;
    private String T;
    private int id;
    private String type;
    private String url;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String F() {
        return this.I;
    }

    public final void u(String str) {
        this.I = str;
    }

    public final String M() {
        return this.T;
    }

    public final void setParameters(String str) {
        this.T = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String I() {
        return this.H;
    }

    public final void x(String str) {
        this.H = str;
    }

    public final String toString() {
        return "NetLogEntity{id=" + this.id + ", url='" + this.url + "', timeStamp='" + this.I + "', parameters='" + this.T + "', type='" + this.type + "', sessionId='" + this.H + "'}";
    }
}
