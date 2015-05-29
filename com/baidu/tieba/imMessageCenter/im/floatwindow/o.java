package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View btC;
    private boolean amH = false;
    protected WindowManager btD = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams btE = Wd();

    public abstract WindowManager.LayoutParams Wd();

    public o(View view) {
        this.btC = view;
    }

    public boolean We() {
        return this.amH && this.btC.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wf() {
        if (this.btD != null && this.btE != null && this.btC.getParent() == null) {
            this.amH = true;
            this.btD.addView(this.btC, this.btE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wg() {
        if (this.btD != null && this.btC.getParent() != null) {
            this.amH = false;
            this.btD.removeView(this.btC);
        }
    }
}
