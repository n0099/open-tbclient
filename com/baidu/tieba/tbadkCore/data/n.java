package com.baidu.tieba.tbadkCore.data;
/* loaded from: classes.dex */
public class n {
    private Object nwp;
    private boolean nwq = false;
    private boolean nwr = false;
    private boolean nws = false;
    public final long nwt = System.currentTimeMillis();

    public n(Object obj) {
        this.nwp = obj;
    }

    public Object dNh() {
        return this.nwp;
    }

    public void aR(Object obj) {
        this.nwp = obj;
    }

    public boolean dNi() {
        return this.nwq;
    }

    public boolean dNj() {
        return this.nwr;
    }

    public void yp(boolean z) {
        this.nwr = z;
    }

    public void yq(boolean z) {
        this.nwq = z;
    }

    public boolean dNk() {
        return this.nws;
    }

    public void yr(boolean z) {
        this.nws = z;
    }

    public boolean isValid() {
        return System.currentTimeMillis() - this.nwt < 1020000;
    }
}
