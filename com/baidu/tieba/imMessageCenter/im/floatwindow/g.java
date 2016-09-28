package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bLr;
    private long dqb;
    private Point dqh;
    protected final int dqi;
    private i dqj;
    private boolean dqk;

    public g(View view) {
        super(view);
        this.dqk = true;
        this.bLr = 0;
        this.dqi = k.K(TbadkCoreApplication.m9getInst());
        this.dqh = new Point();
        this.dqm.setOnTouchListener(new h(this));
        this.bLr = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m9getInst());
        if (this.bLr == 0) {
            this.bLr = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.dqk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, int i2) {
        this.dqb = SystemClock.elapsedRealtime();
        this.dqh.x = i;
        this.dqh.y = i2;
        if (this.dqj != null) {
            this.dqj.aY(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        bb(this.dqh.x + i, (i2 - this.dqh.y) - this.bLr);
        if (this.dqj != null) {
            this.dqj.aX(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axV() {
        if (this.dqj != null) {
            if (SystemClock.elapsedRealtime() - this.dqb > 200) {
                this.dqj.axV();
            } else {
                this.dqj.axW();
            }
        }
    }

    public void a(i iVar) {
        this.dqj = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams axZ() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void ba(int i, int i2) {
        if (this.dqo != null) {
            if (i >= 0) {
                this.dqo.x = i;
            }
            if (i2 >= 0) {
                this.dqo.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bb(int i, int i2) {
        if (this.dqo != null) {
            int i3 = this.dqi - i;
            if (i3 >= 0) {
                this.dqo.x = i3;
            }
            if (i2 >= 0) {
                this.dqo.y = i2;
            }
            if (this.dqn != null && this.dqm.getParent() != null) {
                this.dqn.updateViewLayout(this.dqm, this.dqo);
            }
        }
    }
}
