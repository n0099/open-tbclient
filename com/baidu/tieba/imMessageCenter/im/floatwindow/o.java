package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View btD;
    private boolean amH = false;
    protected WindowManager btE = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams btF = We();

    public abstract WindowManager.LayoutParams We();

    public o(View view) {
        this.btD = view;
    }

    public boolean Wf() {
        return this.amH && this.btD.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wg() {
        if (this.btE != null && this.btF != null && this.btD.getParent() == null) {
            this.amH = true;
            this.btE.addView(this.btD, this.btF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wh() {
        if (this.btE != null && this.btD.getParent() != null) {
            this.amH = false;
            this.btE.removeView(this.btD);
        }
    }
}
