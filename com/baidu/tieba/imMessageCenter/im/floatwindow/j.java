package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bHu;
    private boolean aut = false;
    protected WindowManager bHv = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bHw = XL();

    public abstract WindowManager.LayoutParams XL();

    public j(View view) {
        this.bHu = view;
    }

    public boolean XM() {
        return this.aut && this.bHu.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XN() {
        if (this.bHv != null && this.bHw != null && this.bHu.getParent() == null) {
            this.aut = true;
            this.bHv.addView(this.bHu, this.bHw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XO() {
        if (this.bHv != null && this.bHu.getParent() != null) {
            this.aut = false;
            this.bHv.removeView(this.bHu);
        }
    }
}
