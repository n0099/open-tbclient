package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View ctV;
    private boolean ayw = false;
    protected WindowManager ctW = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams ctX = ajE();

    public abstract WindowManager.LayoutParams ajE();

    public j(View view) {
        this.ctV = view;
    }

    public boolean ajF() {
        return this.ayw && this.ctV.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajG() {
        if (this.ctW != null && this.ctX != null && this.ctV.getParent() == null) {
            this.ayw = true;
            this.ctW.addView(this.ctV, this.ctX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajH() {
        if (this.ctW != null && this.ctV.getParent() != null) {
            this.ayw = false;
            this.ctW.removeView(this.ctV);
        }
    }
}
