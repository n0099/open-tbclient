package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aPv;
    private long bKV;
    private Point bLb;
    protected final int bLc;
    private i bLd;
    private boolean bLe;

    public g(View view) {
        super(view);
        this.bLe = true;
        this.aPv = 0;
        this.bLc = k.K(TbadkCoreApplication.m411getInst());
        this.bLb = new Point();
        this.bLg.setOnTouchListener(new h(this));
        this.aPv = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aPv == 0) {
            this.aPv = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bLe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, int i2) {
        this.bKV = SystemClock.elapsedRealtime();
        this.bLb.x = i;
        this.bLb.y = i2;
        if (this.bLd != null) {
            this.bLd.al(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, int i2) {
        ao(this.bLb.x + i, (i2 - this.bLb.y) - this.aPv);
        if (this.bLd != null) {
            this.bLd.ak(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yr() {
        if (this.bLd != null) {
            if (SystemClock.elapsedRealtime() - this.bKV > 200) {
                this.bLd.Yr();
            } else {
                this.bLd.Ys();
            }
        }
    }

    public void a(i iVar) {
        this.bLd = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams Yv() {
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
        if (this.bLi != null) {
            if (i >= 0) {
                this.bLi.x = i;
            }
            if (i2 >= 0) {
                this.bLi.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(int i, int i2) {
        if (this.bLi != null) {
            int i3 = this.bLc - i;
            if (i3 >= 0) {
                this.bLi.x = i3;
            }
            if (i2 >= 0) {
                this.bLi.y = i2;
            }
            if (this.bLh != null && this.bLg.getParent() != null) {
                this.bLh.updateViewLayout(this.bLg, this.bLi);
            }
        }
    }
}
