package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View dvT;
    private boolean azE = false;
    protected WindowManager dvU = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
    protected WindowManager.LayoutParams dvV = azW();

    public abstract WindowManager.LayoutParams azW();

    public j(View view) {
        this.dvT = view;
    }

    public boolean azX() {
        return this.azE && this.dvT.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azY() {
        if (this.dvU != null && this.dvV != null && this.dvT.getParent() == null) {
            this.azE = true;
            try {
                this.dvU.addView(this.dvT, this.dvV);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azZ() {
        if (this.dvU != null && this.dvT.getParent() != null) {
            this.azE = false;
            try {
                this.dvU.removeView(this.dvT);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
