package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private int aGB;
    private long bqH;
    private Point bqN;
    protected final int bqO;
    private n bqP;
    private boolean bqQ;

    public l(View view) {
        super(view);
        this.bqQ = true;
        this.aGB = 0;
        this.bqO = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        this.bqN = new Point();
        this.bqS.setOnTouchListener(new m(this));
        this.aGB = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (this.aGB == 0) {
            this.aGB = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bqQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, int i2) {
        this.bqH = SystemClock.elapsedRealtime();
        this.bqN.x = i;
        this.bqN.y = i2;
        if (this.bqP != null) {
            this.bqP.V(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, int i2) {
        Y(this.bqN.x + i, (i2 - this.bqN.y) - this.aGB);
        if (this.bqP != null) {
            this.bqP.U(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UI() {
        if (this.bqP != null) {
            if (SystemClock.elapsedRealtime() - this.bqH > 200) {
                this.bqP.UI();
            } else {
                this.bqP.UJ();
            }
        }
    }

    public void a(n nVar) {
        this.bqP = nVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams UM() {
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
        if (this.bqU != null) {
            if (i >= 0) {
                this.bqU.x = i;
            }
            if (i2 >= 0) {
                this.bqU.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(int i, int i2) {
        if (this.bqU != null) {
            int i3 = this.bqO - i;
            if (i3 >= 0) {
                this.bqU.x = i3;
            }
            if (i2 >= 0) {
                this.bqU.y = i2;
            }
            if (this.bqT != null && this.bqS.getParent() != null) {
                this.bqT.updateViewLayout(this.bqS, this.bqU);
            }
        }
    }
}
