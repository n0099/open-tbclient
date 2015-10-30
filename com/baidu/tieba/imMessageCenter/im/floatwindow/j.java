package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bLr;
    private boolean auC = false;
    protected WindowManager bLs = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bLt = Yr();

    public abstract WindowManager.LayoutParams Yr();

    public j(View view) {
        this.bLr = view;
    }

    public boolean Ys() {
        return this.auC && this.bLr.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yt() {
        if (this.bLs != null && this.bLt != null && this.bLr.getParent() == null) {
            this.auC = true;
            this.bLs.addView(this.bLr, this.bLt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yu() {
        if (this.bLs != null && this.bLr.getParent() != null) {
            this.auC = false;
            this.bLs.removeView(this.bLr);
        }
    }
}
