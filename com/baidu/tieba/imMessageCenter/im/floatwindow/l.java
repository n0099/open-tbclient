package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private int aIK;
    private n btA;
    private boolean btB;
    private long bts;
    private Point bty;
    protected final int btz;

    public l(View view) {
        super(view);
        this.btB = true;
        this.aIK = 0;
        this.btz = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst());
        this.bty = new Point();
        this.btD.setOnTouchListener(new m(this));
        this.aIK = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m411getInst());
        if (this.aIK == 0) {
            this.aIK = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.btB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, int i2) {
        this.bts = SystemClock.elapsedRealtime();
        this.bty.x = i;
        this.bty.y = i2;
        if (this.btA != null) {
            this.btA.X(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, int i2) {
        aa(this.bty.x + i, (i2 - this.bty.y) - this.aIK);
        if (this.btA != null) {
            this.btA.W(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (this.btA != null) {
            if (SystemClock.elapsedRealtime() - this.bts > 200) {
                this.btA.Wa();
            } else {
                this.btA.Wb();
            }
        }
    }

    public void a(n nVar) {
        this.btA = nVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.o
    public WindowManager.LayoutParams We() {
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
        if (this.btF != null) {
            if (i >= 0) {
                this.btF.x = i;
            }
            if (i2 >= 0) {
                this.btF.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(int i, int i2) {
        if (this.btF != null) {
            int i3 = this.btz - i;
            if (i3 >= 0) {
                this.btF.x = i3;
            }
            if (i2 >= 0) {
                this.btF.y = i2;
            }
            if (this.btE != null && this.btD.getParent() != null) {
                this.btE.updateViewLayout(this.btD, this.btF);
            }
        }
    }
}
