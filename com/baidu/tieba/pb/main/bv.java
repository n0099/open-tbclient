package com.baidu.tieba.pb.main;

import android.os.Parcelable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class bv {
    private com.baidu.tieba.tbadkCore.b.i bCA;
    private String bCP;
    private boolean bCQ;
    private boolean bCR;
    private Parcelable bCS;
    private boolean bCo;
    private boolean bCp;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004006, new bw());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static bv XZ() {
        bv bvVar;
        bvVar = bx.bCT;
        return bvVar;
    }

    private bv() {
        this.bCP = null;
        this.bCQ = false;
        this.bCA = null;
        this.bCR = false;
        this.bCS = null;
        this.bCp = true;
        this.bCo = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bv(bv bvVar) {
        this();
    }

    public void y(String str, boolean z) {
        this.bCQ = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.bCP = null;
        } else if (!str.equals(this.bCP)) {
            reset();
            this.bCP = str;
        } else {
            this.bCQ = true;
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        if (!this.bCQ) {
            this.bCR = false;
            return null;
        } else if (this.bCA != null && this.bCA.ahf() != null && this.bCA.ahf().size() > 0) {
            this.bCR = true;
            com.baidu.tieba.tbadkCore.b.i iVar = this.bCA;
            this.bCA = null;
            return iVar;
        } else {
            this.bCR = false;
            this.bCA = null;
            return null;
        }
    }

    public Parcelable Ya() {
        if (this.bCR) {
            this.bCR = false;
            Parcelable parcelable = this.bCS;
            this.bCS = null;
            return parcelable;
        }
        this.bCS = null;
        return null;
    }

    public boolean XG() {
        return this.bCp;
    }

    public boolean Yb() {
        return this.bCo;
    }

    public boolean a(com.baidu.tieba.tbadkCore.b.i iVar, Parcelable parcelable, boolean z, boolean z2) {
        this.bCQ = false;
        if (this.bCP == null) {
            reset();
            return false;
        } else if (iVar == null) {
            reset();
            return false;
        } else if (iVar.ahf() == null) {
            reset();
            return false;
        } else if (iVar.ahf().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.bCA = iVar;
            this.bCR = false;
            this.bCS = parcelable;
            this.bCp = z;
            this.bCo = z2;
            return true;
        }
    }

    public void reset() {
        this.bCQ = false;
        this.bCA = null;
        this.bCR = false;
        this.bCS = null;
    }
}
