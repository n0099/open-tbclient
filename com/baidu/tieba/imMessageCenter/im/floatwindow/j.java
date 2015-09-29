package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bLg;
    private boolean auB = false;
    protected WindowManager bLh = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bLi = Yv();

    public abstract WindowManager.LayoutParams Yv();

    public j(View view) {
        this.bLg = view;
    }

    public boolean Yw() {
        return this.auB && this.bLg.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yx() {
        if (this.bLh != null && this.bLi != null && this.bLg.getParent() == null) {
            this.auB = true;
            this.bLh.addView(this.bLg, this.bLi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yy() {
        if (this.bLh != null && this.bLg.getParent() != null) {
            this.auB = false;
            this.bLh.removeView(this.bLg);
        }
    }
}
