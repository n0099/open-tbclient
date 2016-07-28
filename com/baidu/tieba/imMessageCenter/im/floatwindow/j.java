package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View ddg;
    private boolean awc = false;
    protected WindowManager ddh = (WindowManager) TbadkCoreApplication.m10getInst().getSystemService("window");
    protected WindowManager.LayoutParams ddi = asM();

    public abstract WindowManager.LayoutParams asM();

    public j(View view) {
        this.ddg = view;
    }

    public boolean asN() {
        return this.awc && this.ddg.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asO() {
        if (this.ddh != null && this.ddi != null && this.ddg.getParent() == null) {
            this.awc = true;
            this.ddh.addView(this.ddg, this.ddi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asP() {
        if (this.ddh != null && this.ddg.getParent() != null) {
            this.awc = false;
            this.ddh.removeView(this.ddg);
        }
    }
}
