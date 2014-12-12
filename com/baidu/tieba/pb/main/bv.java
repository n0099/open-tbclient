package com.baidu.tieba.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class bv {
    private boolean bAF;
    private boolean bAG;
    private com.baidu.tieba.tbadkCore.b.i bAR;
    private String bBg;
    private boolean bBh;
    private boolean bBi;
    private Parcelable bBj;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004006, new bw());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static bv Xz() {
        bv bvVar;
        bvVar = bx.bBk;
        return bvVar;
    }

    private bv() {
        this.bBg = null;
        this.bBh = false;
        this.bAR = null;
        this.bBi = false;
        this.bBj = null;
        this.bAG = true;
        this.bAF = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bv(bv bvVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bBh = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bBg = null;
        } else if (!str.equals(this.bBg)) {
            reset();
            this.bBg = str;
        } else {
            this.bBh = true;
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        if (!this.bBh) {
            this.bBi = false;
            return null;
        } else if (this.bAR != null && this.bAR.agF() != null && this.bAR.agF().size() > 0) {
            this.bBi = true;
            com.baidu.tieba.tbadkCore.b.i iVar = this.bAR;
            this.bAR = null;
            return iVar;
        } else {
            this.bBi = false;
            this.bAR = null;
            return null;
        }
    }

    public Parcelable XA() {
        if (this.bBi) {
            this.bBi = false;
            Parcelable parcelable = this.bBj;
            this.bBj = null;
            return parcelable;
        }
        this.bBj = null;
        return null;
    }

    public boolean Xg() {
        return this.bAG;
    }

    public boolean XB() {
        return this.bAF;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bBh = false;
        if (this.bBg == null) {
            reset();
            return false;
        } else if (iVar == null) {
            reset();
            return false;
        } else if (iVar.agF() == null) {
            reset();
            return false;
        } else if (iVar.agF().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bAR = iVar;
            this.bBi = false;
            this.bBj = parcelable;
            this.bAG = z;
            this.bAF = z2;
            return true;
        }
    }

    public void reset() {
        this.bBh = false;
        this.bAR = null;
        this.bBi = false;
        this.bBj = null;
    }
}
