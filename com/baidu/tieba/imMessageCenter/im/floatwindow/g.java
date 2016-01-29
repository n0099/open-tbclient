package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bbg;
    private long cjf;
    private Point cjl;
    protected final int cjm;
    private i cjn;
    private boolean cjo;

    public g(View view) {
        super(view);
        this.cjo = true;
        this.bbg = 0;
        this.cjm = k.K(TbadkCoreApplication.m411getInst());
        this.cjl = new Point();
        this.cjq.setOnTouchListener(new h(this));
        this.bbg = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.bbg == 0) {
            this.bbg = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.cjo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(int i, int i2) {
        this.cjf = SystemClock.elapsedRealtime();
        this.cjl.x = i;
        this.cjl.y = i2;
        if (this.cjn != null) {
            this.cjn.aC(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, int i2) {
        aF(this.cjl.x + i, (i2 - this.cjl.y) - this.bbg);
        if (this.cjn != null) {
            this.cjn.aB(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        if (this.cjn != null) {
            if (SystemClock.elapsedRealtime() - this.cjf > 200) {
                this.cjn.agg();
            } else {
                this.cjn.agh();
            }
        }
    }

    public void a(i iVar) {
        this.cjn = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams agk() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aE(int i, int i2) {
        if (this.cjs != null) {
            if (i >= 0) {
                this.cjs.x = i;
            }
            if (i2 >= 0) {
                this.cjs.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aF(int i, int i2) {
        if (this.cjs != null) {
            int i3 = this.cjm - i;
            if (i3 >= 0) {
                this.cjs.x = i3;
            }
            if (i2 >= 0) {
                this.cjs.y = i2;
            }
            if (this.cjr != null && this.cjq.getParent() != null) {
                this.cjr.updateViewLayout(this.cjq, this.cjs);
            }
        }
    }
}
