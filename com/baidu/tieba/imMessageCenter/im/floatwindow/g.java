package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aQl;
    private long bHj;
    private Point bHp;
    protected final int bHq;
    private i bHr;
    private boolean bHs;

    public g(View view) {
        super(view);
        this.bHs = true;
        this.aQl = 0;
        this.bHq = k.K(TbadkCoreApplication.m411getInst());
        this.bHp = new Point();
        this.bHu.setOnTouchListener(new h(this));
        this.aQl = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aQl == 0) {
            this.aQl = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bHs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, int i2) {
        this.bHj = SystemClock.elapsedRealtime();
        this.bHp.x = i;
        this.bHp.y = i2;
        if (this.bHr != null) {
            this.bHr.ak(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i, int i2) {
        an(this.bHp.x + i, (i2 - this.bHp.y) - this.aQl);
        if (this.bHr != null) {
            this.bHr.aj(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XH() {
        if (this.bHr != null) {
            if (SystemClock.elapsedRealtime() - this.bHj > 200) {
                this.bHr.XH();
            } else {
                this.bHr.XI();
            }
        }
    }

    public void a(i iVar) {
        this.bHr = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams XL() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void am(int i, int i2) {
        if (this.bHw != null) {
            if (i >= 0) {
                this.bHw.x = i;
            }
            if (i2 >= 0) {
                this.bHw.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(int i, int i2) {
        if (this.bHw != null) {
            int i3 = this.bHq - i;
            if (i3 >= 0) {
                this.bHw.x = i3;
            }
            if (i2 >= 0) {
                this.bHw.y = i2;
            }
            if (this.bHv != null && this.bHu.getParent() != null) {
                this.bHv.updateViewLayout(this.bHu, this.bHw);
            }
        }
    }
}
