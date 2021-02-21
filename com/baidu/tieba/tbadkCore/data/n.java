package com.baidu.tieba.tbadkCore.data;
/* loaded from: classes.dex */
public class n {
    private Object nwP;
    private boolean nwQ = false;
    private boolean nwR = false;
    private boolean nwS = false;
    public final long nwT = System.currentTimeMillis();

    public n(Object obj) {
        this.nwP = obj;
    }

    public Object dNp() {
        return this.nwP;
    }

    public void aR(Object obj) {
        this.nwP = obj;
    }

    public boolean dNq() {
        return this.nwQ;
    }

    public boolean dNr() {
        return this.nwR;
    }

    public void yp(boolean z) {
        this.nwR = z;
    }

    public void yq(boolean z) {
        this.nwQ = z;
    }

    public boolean dNs() {
        return this.nwS;
    }

    public void yr(boolean z) {
        this.nwS = z;
    }

    public boolean isValid() {
        return System.currentTimeMillis() - this.nwT < 1020000;
    }
}
