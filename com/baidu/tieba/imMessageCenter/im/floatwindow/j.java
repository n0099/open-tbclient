package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View ceR;
    private boolean awY = false;
    protected WindowManager ceS = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams ceT = adb();

    public abstract WindowManager.LayoutParams adb();

    public j(View view) {
        this.ceR = view;
    }

    public boolean adc() {
        return this.awY && this.ceR.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add() {
        if (this.ceS != null && this.ceT != null && this.ceR.getParent() == null) {
            this.awY = true;
            this.ceS.addView(this.ceR, this.ceT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ade() {
        if (this.ceS != null && this.ceR.getParent() != null) {
            this.awY = false;
            this.ceS.removeView(this.ceR);
        }
    }
}
