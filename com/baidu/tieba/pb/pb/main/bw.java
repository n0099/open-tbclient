package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bw {
    private boolean cbT;
    private boolean cbU;
    private com.baidu.tieba.pb.a.b ccg;
    private String cdC;
    private boolean cdD;
    private boolean cdE;
    private Parcelable cdF;

    static {
        MessageManager.getInstance().registerListener(new bx(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new by(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    /* loaded from: classes.dex */
    private static class a {
        private static bw cdG = new bw(null);
    }

    public static bw adS() {
        return a.cdG;
    }

    private bw() {
        this.cdC = null;
        this.cdD = false;
        this.ccg = null;
        this.cdE = false;
        this.cdF = null;
        this.cbU = true;
        this.cbT = false;
    }

    /* synthetic */ bw(bw bwVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.cdD = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cdC = null;
        } else if (!str.equals(this.cdC)) {
            reset();
            this.cdC = str;
        } else {
            this.cdD = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.cdD) {
            this.cdE = false;
            return null;
        } else if (this.ccg != null && this.ccg.acI() != null && this.ccg.acI().size() > 0) {
            this.cdE = true;
            com.baidu.tieba.pb.a.b bVar = this.ccg;
            this.ccg = null;
            return bVar;
        } else {
            this.cdE = false;
            this.ccg = null;
            return null;
        }
    }

    public Parcelable adT() {
        if (this.cdE) {
            this.cdE = false;
            Parcelable parcelable = this.cdF;
            this.cdF = null;
            return parcelable;
        }
        this.cdF = null;
        return null;
    }

    public boolean ady() {
        return this.cbU;
    }

    public boolean adU() {
        return this.cbT;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.cdD = false;
        if (this.cdC == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.acI() == null) {
            reset();
            return false;
        } else if (bVar.acI().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.ccg = bVar;
            this.cdE = false;
            this.cdF = parcelable;
            this.cbU = z;
            this.cbT = z2;
            return true;
        }
    }

    public void reset() {
        this.cdD = false;
        this.ccg = null;
        this.cdE = false;
        this.cdF = null;
    }
}
