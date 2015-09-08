package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bw {
    private boolean ccO;
    private boolean ccP;
    private com.baidu.tieba.pb.a.b cdb;
    private boolean ceA;
    private boolean ceB;
    private Parcelable ceC;
    private String cez;

    static {
        MessageManager.getInstance().registerListener(new bx(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
        MessageManager.getInstance().registerListener(new by(CmdConfigCustom.PB_RECORDER_RESET_CMD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static bw ceD = new bw(null);
    }

    public static bw aeg() {
        return a.ceD;
    }

    private bw() {
        this.cez = null;
        this.ceA = false;
        this.cdb = null;
        this.ceB = false;
        this.ceC = null;
        this.ccP = true;
        this.ccO = false;
    }

    /* synthetic */ bw(bw bwVar) {
        this();
    }

    public void A(String str, boolean z) {
        this.ceA = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.cez = null;
        } else if (!str.equals(this.cez)) {
            reset();
            this.cez = str;
        } else {
            this.ceA = true;
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        if (!this.ceA) {
            this.ceB = false;
            return null;
        } else if (this.cdb != null && this.cdb.acR() != null && this.cdb.acR().size() > 0) {
            this.ceB = true;
            com.baidu.tieba.pb.a.b bVar = this.cdb;
            this.cdb = null;
            return bVar;
        } else {
            this.ceB = false;
            this.cdb = null;
            return null;
        }
    }

    public Parcelable aeh() {
        if (this.ceB) {
            this.ceB = false;
            Parcelable parcelable = this.ceC;
            this.ceC = null;
            return parcelable;
        }
        this.ceC = null;
        return null;
    }

    public boolean adM() {
        return this.ccP;
    }

    public boolean aei() {
        return this.ccO;
    }

    public boolean a(com.baidu.tieba.pb.a.b bVar, Parcelable parcelable, boolean z, boolean z2) {
        this.ceA = false;
        if (this.cez == null) {
            reset();
            return false;
        } else if (bVar == null) {
            reset();
            return false;
        } else if (bVar.acR() == null) {
            reset();
            return false;
        } else if (bVar.acR().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.cdb = bVar;
            this.ceB = false;
            this.ceC = parcelable;
            this.ccP = z;
            this.ccO = z2;
            return true;
        }
    }

    public void reset() {
        this.ceA = false;
        this.cdb = null;
        this.ceB = false;
        this.ceC = null;
    }
}
