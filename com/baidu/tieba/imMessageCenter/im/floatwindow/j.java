package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View cjq;
    private boolean axP = false;
    protected WindowManager cjr = (WindowManager) TbadkCoreApplication.m411getInst().getSystemService("window");
    protected WindowManager.LayoutParams cjs = agk();

    public abstract WindowManager.LayoutParams agk();

    public j(View view) {
        this.cjq = view;
    }

    public boolean agl() {
        return this.axP && this.cjq.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agm() {
        if (this.cjr != null && this.cjs != null && this.cjq.getParent() == null) {
            this.axP = true;
            this.cjr.addView(this.cjq, this.cjs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agn() {
        if (this.cjr != null && this.cjq.getParent() != null) {
            this.axP = false;
            this.cjr.removeView(this.cjq);
        }
    }
}
