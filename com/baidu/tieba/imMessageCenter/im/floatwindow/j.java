package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View dqm;
    private boolean ayM = false;
    protected WindowManager dqn = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
    protected WindowManager.LayoutParams dqo = axZ();

    public abstract WindowManager.LayoutParams axZ();

    public j(View view) {
        this.dqm = view;
    }

    public boolean aya() {
        return this.ayM && this.dqm.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayb() {
        if (this.dqn != null && this.dqo != null && this.dqm.getParent() == null) {
            this.ayM = true;
            this.dqn.addView(this.dqm, this.dqo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayc() {
        if (this.dqn != null && this.dqm.getParent() != null) {
            this.ayM = false;
            this.dqn.removeView(this.dqm);
        }
    }
}
