package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aPG;
    private long bLg;
    private Point bLm;
    protected final int bLn;
    private i bLo;
    private boolean bLp;

    public g(View view) {
        super(view);
        this.bLp = true;
        this.aPG = 0;
        this.bLn = k.K(TbadkCoreApplication.m411getInst());
        this.bLm = new Point();
        this.bLr.setOnTouchListener(new h(this));
        this.aPG = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aPG == 0) {
            this.aPG = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bLp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        this.bLg = SystemClock.elapsedRealtime();
        this.bLm.x = i;
        this.bLm.y = i2;
        if (this.bLo != null) {
            this.bLo.al(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, int i2) {
        ao(this.bLm.x + i, (i2 - this.bLm.y) - this.aPG);
        if (this.bLo != null) {
            this.bLo.ak(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yn() {
        if (this.bLo != null) {
            if (SystemClock.elapsedRealtime() - this.bLg > 200) {
                this.bLo.Yn();
            } else {
                this.bLo.Yo();
            }
        }
    }

    public void a(i iVar) {
        this.bLo = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams Yr() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void an(int i, int i2) {
        if (this.bLt != null) {
            if (i >= 0) {
                this.bLt.x = i;
            }
            if (i2 >= 0) {
                this.bLt.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(int i, int i2) {
        if (this.bLt != null) {
            int i3 = this.bLn - i;
            if (i3 >= 0) {
                this.bLt.x = i3;
            }
            if (i2 >= 0) {
                this.bLt.y = i2;
            }
            if (this.bLs != null && this.bLr.getParent() != null) {
                this.bLs.updateViewLayout(this.bLr, this.bLt);
            }
        }
    }
}
