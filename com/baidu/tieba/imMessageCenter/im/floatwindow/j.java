package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View caQ;
    private boolean avu = false;
    protected WindowManager caR = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams caS = abS();

    public abstract WindowManager.LayoutParams abS();

    public j(View view) {
        this.caQ = view;
    }

    public boolean abT() {
        return this.avu && this.caQ.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abU() {
        if (this.caR != null && this.caS != null && this.caQ.getParent() == null) {
            this.avu = true;
            this.caR.addView(this.caQ, this.caS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abV() {
        if (this.caR != null && this.caQ.getParent() != null) {
            this.avu = false;
            this.caR.removeView(this.caQ);
        }
    }
}
