package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View bqC;
    private boolean aly = false;
    protected WindowManager bqD = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bqE = Uz();

    public abstract WindowManager.LayoutParams Uz();

    public o(View view) {
        this.bqC = view;
    }

    public boolean UA() {
        return this.aly && this.bqC.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UB() {
        if (this.bqD != null && this.bqE != null && this.bqC.getParent() == null) {
            this.aly = true;
            this.bqD.addView(this.bqC, this.bqE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UC() {
        if (this.bqD != null && this.bqC.getParent() != null) {
            this.aly = false;
            this.bqD.removeView(this.bqC);
        }
    }
}
