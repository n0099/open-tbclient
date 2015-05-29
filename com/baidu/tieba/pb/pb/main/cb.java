package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class cb {
    private com.baidu.tieba.pb.a.b bLH;
    private boolean bLu;
    private boolean bLv;
    private String bMZ;
    private boolean bNa;
    private boolean bNb;
    private Parcelable bNc;

    static {
        MessageManager.getInstance().registerListener(new cc(2005016));
        MessageManager.getInstance().registerListener(new cd(2004006));
    }

    public static cb abK() {
        cb cbVar;
        cbVar = ce.bNd;
        return cbVar;
    }

    private cb() {
        this.bMZ = null;
        this.bNa = false;
        this.bLH = null;
        this.bNb = false;
        this.bNc = null;
        this.bLv = true;
        this.bLu = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cb(cb cbVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bNa = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bMZ = null;
        } else if (!str.equals(this.bMZ)) {
            reset();
            this.bMZ = str;
        } else {
            this.bNa = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.bNa) {
            this.bNb = false;
            return null;
        } else if (this.bLH != null && this.bLH.aat() != null && this.bLH.aat().size() > 0) {
            this.bNb = true;
            com.baidu.tieba.pb.a.b bVar = this.bLH;
            this.bLH = null;
            return bVar;
        } else {
            this.bNb = false;
            this.bLH = null;
            return null;
        }
    }

    public Parcelable abL() {
        if (this.bNb) {
            this.bNb = false;
            Parcelable parcelable = this.bNc;
            this.bNc = null;
            return parcelable;
        }
        this.bNc = null;
        return null;
    }

    public boolean abp() {
        return this.bLv;
    }

    public boolean abM() {
        return this.bLu;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bNa = false;
        if (this.bMZ == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.aat() == null) {
            reset();
            return false;
        } else if (bVar.aat().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bLH = bVar;
            this.bNb = false;
            this.bNc = parcelable;
            this.bLv = z;
            this.bLu = z2;
            return true;
        }
    }

    public void reset() {
        this.bNa = false;
        this.bLH = null;
        this.bNb = false;
        this.bNc = null;
    }
}
