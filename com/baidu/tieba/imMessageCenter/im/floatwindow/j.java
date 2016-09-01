package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View doO;
    private boolean azj = false;
    protected WindowManager doP = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
    protected WindowManager.LayoutParams doQ = axA();

    public abstract WindowManager.LayoutParams axA();

    public j(View view) {
        this.doO = view;
    }

    public boolean axB() {
        return this.azj && this.doO.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void axC() {
        if (this.doP != null && this.doQ != null && this.doO.getParent() == null) {
            this.azj = true;
            this.doP.addView(this.doO, this.doQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void axD() {
        if (this.doP != null && this.doO.getParent() != null) {
            this.azj = false;
            this.doP.removeView(this.doO);
        }
    }
}
