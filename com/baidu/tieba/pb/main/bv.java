package com.baidu.tieba.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class bv {
    private com.baidu.tieba.tbadkCore.b.i bCB;
    private String bCQ;
    private boolean bCR;
    private boolean bCS;
    private Parcelable bCT;
    private boolean bCp;
    private boolean bCq;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004006, new bw());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static bv Ye() {
        bv bvVar;
        bvVar = bx.bCU;
        return bvVar;
    }

    private bv() {
        this.bCQ = null;
        this.bCR = false;
        this.bCB = null;
        this.bCS = false;
        this.bCT = null;
        this.bCq = true;
        this.bCp = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bv(bv bvVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bCR = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bCQ = null;
        } else if (!str.equals(this.bCQ)) {
            reset();
            this.bCQ = str;
        } else {
            this.bCR = true;
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        if (!this.bCR) {
            this.bCS = false;
            return null;
        } else if (this.bCB != null && this.bCB.ahk() != null && this.bCB.ahk().size() > 0) {
            this.bCS = true;
            com.baidu.tieba.tbadkCore.b.i iVar = this.bCB;
            this.bCB = null;
            return iVar;
        } else {
            this.bCS = false;
            this.bCB = null;
            return null;
        }
    }

    public Parcelable Yf() {
        if (this.bCS) {
            this.bCS = false;
            Parcelable parcelable = this.bCT;
            this.bCT = null;
            return parcelable;
        }
        this.bCT = null;
        return null;
    }

    public boolean XL() {
        return this.bCq;
    }

    public boolean Yg() {
        return this.bCp;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bCR = false;
        if (this.bCQ == null) {
            reset();
            return false;
        } else if (iVar == null) {
            reset();
            return false;
        } else if (iVar.ahk() == null) {
            reset();
            return false;
        } else if (iVar.ahk().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bCB = iVar;
            this.bCS = false;
            this.bCT = parcelable;
            this.bCq = z;
            this.bCp = z2;
            return true;
        }
    }

    public void reset() {
        this.bCR = false;
        this.bCB = null;
        this.bCS = false;
        this.bCT = null;
    }
}
