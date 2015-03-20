package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class cd {
    private boolean bJa;
    private boolean bJb;
    private com.baidu.tieba.pb.a.b bJm;
    private String bKE;
    private boolean bKF;
    private boolean bKG;
    private Parcelable bKH;

    static {
        MessageManager.getInstance().registerListener(new ce(2005016));
        MessageManager.getInstance().registerListener(new cf(2004006));
    }

    public static cd aaj() {
        cd cdVar;
        cdVar = cg.bKI;
        return cdVar;
    }

    private cd() {
        this.bKE = null;
        this.bKF = false;
        this.bJm = null;
        this.bKG = false;
        this.bKH = null;
        this.bJb = true;
        this.bJa = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cd(cd cdVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bKF = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bKE = null;
        } else if (!str.equals(this.bKE)) {
            reset();
            this.bKE = str;
        } else {
            this.bKF = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.bKF) {
            this.bKG = false;
            return null;
        } else if (this.bJm != null && this.bJm.YQ() != null && this.bJm.YQ().size() > 0) {
            this.bKG = true;
            com.baidu.tieba.pb.a.b bVar = this.bJm;
            this.bJm = null;
            return bVar;
        } else {
            this.bKG = false;
            this.bJm = null;
            return null;
        }
    }

    public Parcelable aak() {
        if (this.bKG) {
            this.bKG = false;
            Parcelable parcelable = this.bKH;
            this.bKH = null;
            return parcelable;
        }
        this.bKH = null;
        return null;
    }

    public boolean ZO() {
        return this.bJb;
    }

    public boolean aal() {
        return this.bJa;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bKF = false;
        if (this.bKE == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.YQ() == null) {
            reset();
            return false;
        } else if (bVar.YQ().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bJm = bVar;
            this.bKG = false;
            this.bKH = parcelable;
            this.bJb = z;
            this.bJa = z2;
            return true;
        }
    }

    public void reset() {
        this.bKF = false;
        this.bJm = null;
        this.bKG = false;
        this.bKH = null;
    }
}
