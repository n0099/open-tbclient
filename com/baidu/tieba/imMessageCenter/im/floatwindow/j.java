package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bIb;
    private boolean awd = false;
    protected WindowManager bIc = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bId = XN();

    public abstract WindowManager.LayoutParams XN();

    public j(View view) {
        this.bIb = view;
    }

    public boolean XO() {
        return this.awd && this.bIb.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XP() {
        if (this.bIc != null && this.bId != null && this.bIb.getParent() == null) {
            this.awd = true;
            this.bIc.addView(this.bIb, this.bId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XQ() {
        if (this.bIc != null && this.bIb.getParent() != null) {
            this.awd = false;
            this.bIc.removeView(this.bIb);
        }
    }
}
