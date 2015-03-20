package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private int aGt;
    private boolean bqA;
    private long bqr;
    private Point bqx;
    protected final int bqy;
    private n bqz;

    public l(View view) {
        super(view);
        this.bqA = true;
        this.aGt = 0;
        this.bqy = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        this.bqx = new Point();
        this.bqC.setOnTouchListener(new m(this));
        this.aGt = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (this.aGt == 0) {
            this.aGt = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bqA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, int i2) {
        this.bqr = SystemClock.elapsedRealtime();
        this.bqx.x = i;
        this.bqx.y = i2;
        if (this.bqz != null) {
            this.bqz.V(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, int i2) {
        Y(this.bqx.x + i, (i2 - this.bqx.y) - this.aGt);
        if (this.bqz != null) {
            this.bqz.U(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uv() {
        if (this.bqz != null) {
            if (SystemClock.elapsedRealtime() - this.bqr > 200) {
                this.bqz.Uv();
            } else {
                this.bqz.Uw();
            }
        }
    }

    public void a(n nVar) {
        this.bqz = nVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams Uz() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void X(int i, int i2) {
        if (this.bqE != null) {
            if (i >= 0) {
                this.bqE.x = i;
            }
            if (i2 >= 0) {
                this.bqE.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(int i, int i2) {
        if (this.bqE != null) {
            int i3 = this.bqy - i;
            if (i3 >= 0) {
                this.bqE.x = i3;
            }
            if (i2 >= 0) {
                this.bqE.y = i2;
            }
            if (this.bqD != null && this.bqC.getParent() != null) {
                this.bqD.updateViewLayout(this.bqC, this.bqE);
            }
        }
    }
}
