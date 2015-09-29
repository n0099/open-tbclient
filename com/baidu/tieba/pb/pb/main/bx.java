package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bx {
    private String cjQ;
    private boolean cjR;
    private boolean cjS;
    private Parcelable cjT;
    private boolean cjb;
    private boolean cjd;
    private com.baidu.tieba.pb.a.b cjp;

    static {
        MessageManager.getInstance().registerListener(new by(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new bz(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static bx cjU = new bx(null);
    }

    public static bx age() {
        return a.cjU;
    }

    private bx() {
        this.cjQ = null;
        this.cjR = false;
        this.cjp = null;
        this.cjS = false;
        this.cjT = null;
        this.cjd = true;
        this.cjb = false;
    }

    /* synthetic */ bx(bx bxVar) {
        this();
    }

    public void B(String str, boolean z) {
        this.cjR = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cjQ = null;
        } else if (!str.equals(this.cjQ)) {
            reset();
            this.cjQ = str;
        } else {
            this.cjR = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.cjR) {
            this.cjS = false;
            return null;
        } else if (this.cjp != null && this.cjp.aeP() != null && this.cjp.aeP().size() > 0) {
            this.cjS = true;
            com.baidu.tieba.pb.a.b bVar = this.cjp;
            this.cjp = null;
            return bVar;
        } else {
            this.cjS = false;
            this.cjp = null;
            return null;
        }
    }

    public Parcelable agf() {
        if (this.cjS) {
            this.cjS = false;
            Parcelable parcelable = this.cjT;
            this.cjT = null;
            return parcelable;
        }
        this.cjT = null;
        return null;
    }

    public boolean afL() {
        return this.cjd;
    }

    public boolean agg() {
        return this.cjb;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.cjR = false;
        if (this.cjQ == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.aeP() == null) {
            reset();
            return false;
        } else if (bVar.aeP().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.cjp = bVar;
            this.cjS = false;
            this.cjT = parcelable;
            this.cjd = z;
            this.cjb = z2;
            return true;
        }
    }

    public void reset() {
        this.cjR = false;
        this.cjp = null;
        this.cjS = false;
        this.cjT = null;
    }
}
