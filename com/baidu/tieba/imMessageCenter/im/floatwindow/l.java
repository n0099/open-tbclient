package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private int aIJ;
    private boolean btA;
    private long btr;
    private Point btx;
    protected final int bty;
    private n btz;

    public l(View view) {
        super(view);
        this.btA = true;
        this.aIJ = 0;
        this.bty = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        this.btx = new Point();
        this.btC.setOnTouchListener(new m(this));
        this.aIJ = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (this.aIJ == 0) {
            this.aIJ = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.btA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, int i2) {
        this.btr = SystemClock.elapsedRealtime();
        this.btx.x = i;
        this.btx.y = i2;
        if (this.btz != null) {
            this.btz.X(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, int i2) {
        aa(this.btx.x + i, (i2 - this.btx.y) - this.aIJ);
        if (this.btz != null) {
            this.btz.W(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VZ() {
        if (this.btz != null) {
            if (SystemClock.elapsedRealtime() - this.btr > 200) {
                this.btz.VZ();
            } else {
                this.btz.Wa();
            }
        }
    }

    public void a(n nVar) {
        this.btz = nVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams Wd() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void Z(int i, int i2) {
        if (this.btE != null) {
            if (i >= 0) {
                this.btE.x = i;
            }
            if (i2 >= 0) {
                this.btE.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(int i, int i2) {
        if (this.btE != null) {
            int i3 = this.bty - i;
            if (i3 >= 0) {
                this.btE.x = i3;
            }
            if (i2 >= 0) {
                this.btE.y = i2;
            }
            if (this.btD != null && this.btC.getParent() != null) {
                this.btD.updateViewLayout(this.btC, this.btE);
            }
        }
    }
}
