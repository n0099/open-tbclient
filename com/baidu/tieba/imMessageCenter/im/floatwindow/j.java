package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bLr;
    private boolean auC = false;
    protected WindowManager bLs = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bLt = Yv();

    public abstract WindowManager.LayoutParams Yv();

    public j(View view) {
        this.bLr = view;
    }

    public boolean Yw() {
        return this.auC && this.bLr.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yx() {
        if (this.bLs != null && this.bLt != null && this.bLr.getParent() == null) {
            this.auC = true;
            this.bLs.addView(this.bLr, this.bLt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yy() {
        if (this.bLs != null && this.bLr.getParent() != null) {
            this.auC = false;
            this.bLs.removeView(this.bLr);
        }
    }
}
