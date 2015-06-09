package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class cb {
    private com.baidu.tieba.pb.a.b bLI;
    private boolean bLv;
    private boolean bLw;
    private String bNa;
    private boolean bNb;
    private boolean bNc;
    private Parcelable bNd;

    static {
        MessageManager.getInstance().registerListener(new cc(2005016));
        MessageManager.getInstance().registerListener(new cd(2004006));
    }

    public static cb abL() {
        cb cbVar;
        cbVar = ce.bNe;
        return cbVar;
    }

    private cb() {
        this.bNa = null;
        this.bNb = false;
        this.bLI = null;
        this.bNc = false;
        this.bNd = null;
        this.bLw = true;
        this.bLv = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cb(cb cbVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bNb = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bNa = null;
        } else if (!str.equals(this.bNa)) {
            reset();
            this.bNa = str;
        } else {
            this.bNb = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.bNb) {
            this.bNc = false;
            return null;
        } else if (this.bLI != null && this.bLI.aau() != null && this.bLI.aau().size() > 0) {
            this.bNc = true;
            com.baidu.tieba.pb.a.b bVar = this.bLI;
            this.bLI = null;
            return bVar;
        } else {
            this.bNc = false;
            this.bLI = null;
            return null;
        }
    }

    public Parcelable abM() {
        if (this.bNc) {
            this.bNc = false;
            Parcelable parcelable = this.bNd;
            this.bNd = null;
            return parcelable;
        }
        this.bNd = null;
        return null;
    }

    public boolean abq() {
        return this.bLw;
    }

    public boolean abN() {
        return this.bLv;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bNb = false;
        if (this.bNa == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.aau() == null) {
            reset();
            return false;
        } else if (bVar.aau().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bLI = bVar;
            this.bNc = false;
            this.bNd = parcelable;
            this.bLw = z;
            this.bLv = z2;
            return true;
        }
    }

    public void reset() {
        this.bNb = false;
        this.bLI = null;
        this.bNc = false;
        this.bNd = null;
    }
}
