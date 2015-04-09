package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View bqS;
    private boolean alG = false;
    protected WindowManager bqT = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bqU = UM();

    public abstract WindowManager.LayoutParams UM();

    public o(View view) {
        this.bqS = view;
    }

    public boolean UN() {
        return this.alG && this.bqS.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UO() {
        if (this.bqT != null && this.bqU != null && this.bqS.getParent() == null) {
            this.alG = true;
            this.bqT.addView(this.bqS, this.bqU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UP() {
        if (this.bqT != null && this.bqS.getParent() != null) {
            this.alG = false;
            this.bqT.removeView(this.bqS);
        }
    }
}
