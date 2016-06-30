package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View dai;
    private boolean avn = false;
    protected WindowManager daj = (WindowManager) TbadkCoreApplication.m9getInst().getSystemService("window");
    protected WindowManager.LayoutParams dak = asa();

    public abstract WindowManager.LayoutParams asa();

    public j(View view) {
        this.dai = view;
    }

    public boolean asb() {
        return this.avn && this.dai.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asc() {
        if (this.daj != null && this.dak != null && this.dai.getParent() == null) {
            this.avn = true;
            this.daj.addView(this.dai, this.dak);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asd() {
        if (this.daj != null && this.dai.getParent() != null) {
            this.avn = false;
            this.daj.removeView(this.dai);
        }
    }
}
