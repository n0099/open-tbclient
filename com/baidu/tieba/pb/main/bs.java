package com.baidu.tieba.pb.main;

import android.os.Parcelable;
/* loaded from: classes.dex */
public class bs {
    private boolean bwN;
    private boolean bwO;
    private com.baidu.tieba.data.ah bwZ;
    private String bxp;
    private boolean bxq;
    private boolean bxr;
    private Parcelable bxs;

    public static bs Xc() {
        bs bsVar;
        bsVar = bt.bxt;
        return bsVar;
    }

    private bs() {
        this.bxp = null;
        this.bxq = false;
        this.bwZ = null;
        this.bxr = false;
        this.bxs = null;
        this.bwO = true;
        this.bwN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(bs bsVar) {
        this();
    }

    public void A(String str, boolean z) {
        this.bxq = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bxp = null;
        } else if (!str.equals(this.bxp)) {
            reset();
            this.bxp = str;
        } else {
            this.bxq = true;
        }
    }

    public com.baidu.tieba.data.ah getPbData() {
        if (!this.bxq) {
            this.bxr = false;
            return null;
        } else if (this.bwZ != null && this.bwZ.zN() != null && this.bwZ.zN().size() > 0) {
            this.bxr = true;
            com.baidu.tieba.data.ah ahVar = this.bwZ;
            this.bwZ = null;
            return ahVar;
        } else {
            this.bxr = false;
            this.bwZ = null;
            return null;
        }
    }

    public Parcelable Xd() {
        if (this.bxr) {
            this.bxr = false;
            Parcelable parcelable = this.bxs;
            this.bxs = null;
            return parcelable;
        }
        this.bxs = null;
        return null;
    }

    public boolean WJ() {
        return this.bwO;
    }

    public boolean Xe() {
        return this.bwN;
    }

    public boolean a(com.baidu.tieba.data.ah ahVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bxq = false;
        if (this.bxp == null) {
            reset();
            return false;
        } else if (ahVar == null) {
            reset();
            return false;
        } else if (ahVar.zN() == null) {
            reset();
            return false;
        } else if (ahVar.zN().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bwZ = ahVar;
            this.bxr = false;
            this.bxs = parcelable;
            this.bwO = z;
            this.bwN = z2;
            return true;
        }
    }

    public void reset() {
        this.bxq = false;
        this.bwZ = null;
        this.bxr = false;
        this.bxs = null;
    }
}
