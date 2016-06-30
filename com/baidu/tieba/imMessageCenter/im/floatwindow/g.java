package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bxA;
    private long cZX;
    private Point dad;
    protected final int dae;
    private i daf;
    private boolean dag;

    public g(View view) {
        super(view);
        this.dag = true;
        this.bxA = 0;
        this.dae = k.A(TbadkCoreApplication.m9getInst());
        this.dad = new Point();
        this.dai.setOnTouchListener(new h(this));
        this.bxA = com.baidu.adp.lib.util.a.w(TbadkCoreApplication.m9getInst());
        if (this.bxA == 0) {
            this.bxA = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.dag = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, int i2) {
        this.cZX = SystemClock.elapsedRealtime();
        this.dad.x = i;
        this.dad.y = i2;
        if (this.daf != null) {
            this.daf.aP(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(int i, int i2) {
        aS(this.dad.x + i, (i2 - this.dad.y) - this.bxA);
        if (this.daf != null) {
            this.daf.aO(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        if (this.daf != null) {
            if (SystemClock.elapsedRealtime() - this.cZX > 200) {
                this.daf.arW();
            } else {
                this.daf.arX();
            }
        }
    }

    public void a(i iVar) {
        this.daf = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams asa() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aR(int i, int i2) {
        if (this.dak != null) {
            if (i >= 0) {
                this.dak.x = i;
            }
            if (i2 >= 0) {
                this.dak.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aS(int i, int i2) {
        if (this.dak != null) {
            int i3 = this.dae - i;
            if (i3 >= 0) {
                this.dak.x = i3;
            }
            if (i2 >= 0) {
                this.dak.y = i2;
            }
            if (this.daj != null && this.dai.getParent() != null) {
                this.daj.updateViewLayout(this.dai, this.dak);
            }
        }
    }
}
