package com.baidu.tieba.pb.main;

import android.os.Parcelable;
/* loaded from: classes.dex */
public class bs {
    private boolean bwA;
    private com.baidu.tieba.data.ah bwL;
    private boolean bwz;
    private String bxb;
    private boolean bxc;
    private boolean bxd;
    private Parcelable bxe;

    public static bs WZ() {
        bs bsVar;
        bsVar = bt.bxf;
        return bsVar;
    }

    private bs() {
        this.bxb = null;
        this.bxc = false;
        this.bwL = null;
        this.bxd = false;
        this.bxe = null;
        this.bwA = true;
        this.bwz = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(bs bsVar) {
        this();
    }

    public void A(String str, boolean z) {
        this.bxc = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bxb = null;
        } else if (!str.equals(this.bxb)) {
            reset();
            this.bxb = str;
        } else {
            this.bxc = true;
        }
    }

    public com.baidu.tieba.data.ah getPbData() {
        if (!this.bxc) {
            this.bxd = false;
            return null;
        } else if (this.bwL != null && this.bwL.zL() != null && this.bwL.zL().size() > 0) {
            this.bxd = true;
            com.baidu.tieba.data.ah ahVar = this.bwL;
            this.bwL = null;
            return ahVar;
        } else {
            this.bxd = false;
            this.bwL = null;
            return null;
        }
    }

    public Parcelable Xa() {
        if (this.bxd) {
            this.bxd = false;
            Parcelable parcelable = this.bxe;
            this.bxe = null;
            return parcelable;
        }
        this.bxe = null;
        return null;
    }

    public boolean WG() {
        return this.bwA;
    }

    public boolean Xb() {
        return this.bwz;
    }

    public boolean a(com.baidu.tieba.data.ah ahVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bxc = false;
        if (this.bxb == null) {
            reset();
            return false;
        } else if (ahVar == null) {
            reset();
            return false;
        } else if (ahVar.zL() == null) {
            reset();
            return false;
        } else if (ahVar.zL().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bwL = ahVar;
            this.bxd = false;
            this.bxe = parcelable;
            this.bwA = z;
            this.bwz = z2;
            return true;
        }
    }

    public void reset() {
        this.bxc = false;
        this.bwL = null;
        this.bxd = false;
        this.bxe = null;
    }
}
