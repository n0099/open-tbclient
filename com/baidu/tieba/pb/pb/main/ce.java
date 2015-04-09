package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class ce {
    private com.baidu.tieba.pb.a.b bJB;
    private boolean bJo;
    private boolean bJp;
    private String bKT;
    private boolean bKU;
    private boolean bKV;
    private Parcelable bKW;

    static {
        MessageManager.getInstance().registerListener(new cf(2005016));
        MessageManager.getInstance().registerListener(new cg(2004006));
    }

    public static ce aaw() {
        ce ceVar;
        ceVar = ch.bKX;
        return ceVar;
    }

    private ce() {
        this.bKT = null;
        this.bKU = false;
        this.bJB = null;
        this.bKV = false;
        this.bKW = null;
        this.bJp = true;
        this.bJo = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ce(ce ceVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bKU = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bKT = null;
        } else if (!str.equals(this.bKT)) {
            reset();
            this.bKT = str;
        } else {
            this.bKU = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.bKU) {
            this.bKV = false;
            return null;
        } else if (this.bJB != null && this.bJB.Zc() != null && this.bJB.Zc().size() > 0) {
            this.bKV = true;
            com.baidu.tieba.pb.a.b bVar = this.bJB;
            this.bJB = null;
            return bVar;
        } else {
            this.bKV = false;
            this.bJB = null;
            return null;
        }
    }

    public Parcelable aax() {
        if (this.bKV) {
            this.bKV = false;
            Parcelable parcelable = this.bKW;
            this.bKW = null;
            return parcelable;
        }
        this.bKW = null;
        return null;
    }

    public boolean aab() {
        return this.bJp;
    }

    public boolean aay() {
        return this.bJo;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bKU = false;
        if (this.bKT == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.Zc() == null) {
            reset();
            return false;
        } else if (bVar.Zc().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bJB = bVar;
            this.bKV = false;
            this.bKW = parcelable;
            this.bJp = z;
            this.bJo = z2;
            return true;
        }
    }

    public void reset() {
        this.bKU = false;
        this.bJB = null;
        this.bKV = false;
        this.bKW = null;
    }
}
