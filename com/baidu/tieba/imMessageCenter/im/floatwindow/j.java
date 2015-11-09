package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View bLM;
    private boolean atq = false;
    protected WindowManager bLN = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams bLO = YM();

    public abstract WindowManager.LayoutParams YM();

    public j(View view) {
        this.bLM = view;
    }

    public boolean YN() {
        return this.atq && this.bLM.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YO() {
        if (this.bLN != null && this.bLO != null && this.bLM.getParent() == null) {
            this.atq = true;
            this.bLN.addView(this.bLM, this.bLO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YP() {
        if (this.bLN != null && this.bLM.getParent() != null) {
            this.atq = false;
            this.bLN.removeView(this.bLM);
        }
    }
}
