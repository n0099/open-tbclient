package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bx {
    private com.baidu.tieba.pb.a.b cjA;
    private boolean cjm;
    private boolean cjo;
    private String ckb;
    private boolean ckc;
    private boolean ckd;
    private Parcelable cke;

    static {
        MessageManager.getInstance().registerListener(new by(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new bz(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    /* loaded from: classes.dex */
    private static class a {
        private static bx ckf = new bx(null);
    }

    public static bx aga() {
        return a.ckf;
    }

    private bx() {
        this.ckb = null;
        this.ckc = false;
        this.cjA = null;
        this.ckd = false;
        this.cke = null;
        this.cjo = true;
        this.cjm = false;
    }

    /* synthetic */ bx(bx bxVar) {
        this();
    }

    public void B(String str, boolean z) {
        this.ckc = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.ckb = null;
        } else if (!str.equals(this.ckb)) {
            reset();
            this.ckb = str;
        } else {
            this.ckc = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.ckc) {
            this.ckd = false;
            return null;
        } else if (this.cjA != null && this.cjA.aeL() != null && this.cjA.aeL().size() > 0) {
            this.ckd = true;
            com.baidu.tieba.pb.a.b bVar = this.cjA;
            this.cjA = null;
            return bVar;
        } else {
            this.ckd = false;
            this.cjA = null;
            return null;
        }
    }

    public Parcelable agb() {
        if (this.ckd) {
            this.ckd = false;
            Parcelable parcelable = this.cke;
            this.cke = null;
            return parcelable;
        }
        this.cke = null;
        return null;
    }

    public boolean afH() {
        return this.cjo;
    }

    public boolean agc() {
        return this.cjm;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.ckc = false;
        if (this.ckb == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.aeL() == null) {
            reset();
            return false;
        } else if (bVar.aeL().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.cjA = bVar;
            this.ckd = false;
            this.cke = parcelable;
            this.cjo = z;
            this.cjm = z2;
            return true;
        }
    }

    public void reset() {
        this.ckc = false;
        this.cjA = null;
        this.ckd = false;
        this.cke = null;
    }
}
