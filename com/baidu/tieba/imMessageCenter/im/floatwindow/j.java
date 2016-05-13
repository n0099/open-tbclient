package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class j {
    protected View cuT;
    private boolean aux = false;
    protected WindowManager cuU = (WindowManager) TbadkCoreApplication.m11getInst().getSystemService("window");
    protected WindowManager.LayoutParams cuV = ajM();

    public abstract WindowManager.LayoutParams ajM();

    public j(View view) {
        this.cuT = view;
    }

    public boolean ajN() {
        return this.aux && this.cuT.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajO() {
        if (this.cuU != null && this.cuV != null && this.cuT.getParent() == null) {
            this.aux = true;
            this.cuU.addView(this.cuT, this.cuV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajP() {
        if (this.cuU != null && this.cuT.getParent() != null) {
            this.aux = false;
            this.cuU.removeView(this.cuT);
        }
    }
}
