package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bfQ;
    private long ctK;
    private Point ctQ;
    protected final int ctR;
    private i ctS;
    private boolean ctT;

    public g(View view) {
        super(view);
        this.ctT = true;
        this.bfQ = 0;
        this.ctR = k.B(TbadkCoreApplication.m411getInst());
        this.ctQ = new Point();
        this.ctV.setOnTouchListener(new h(this));
        this.bfQ = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m411getInst());
        if (this.bfQ == 0) {
            this.bfQ = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.ctT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(int i, int i2) {
        this.ctK = SystemClock.elapsedRealtime();
        this.ctQ.x = i;
        this.ctQ.y = i2;
        if (this.ctS != null) {
            this.ctS.az(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(int i, int i2) {
        aC(this.ctQ.x + i, (i2 - this.ctQ.y) - this.bfQ);
        if (this.ctS != null) {
            this.ctS.ay(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajA() {
        if (this.ctS != null) {
            if (SystemClock.elapsedRealtime() - this.ctK > 200) {
                this.ctS.ajA();
            } else {
                this.ctS.ajB();
            }
        }
    }

    public void a(i iVar) {
        this.ctS = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams ajE() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aB(int i, int i2) {
        if (this.ctX != null) {
            if (i >= 0) {
                this.ctX.x = i;
            }
            if (i2 >= 0) {
                this.ctX.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aC(int i, int i2) {
        if (this.ctX != null) {
            int i3 = this.ctR - i;
            if (i3 >= 0) {
                this.ctX.x = i3;
            }
            if (i2 >= 0) {
                this.ctX.y = i2;
            }
            if (this.ctW != null && this.ctV.getParent() != null) {
                this.ctW.updateViewLayout(this.ctV, this.ctX);
            }
        }
    }
}
