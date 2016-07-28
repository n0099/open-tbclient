package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bzO;
    private long dcV;
    private Point ddb;
    protected final int ddc;
    private i ddd;
    private boolean dde;

    public g(View view) {
        super(view);
        this.dde = true;
        this.bzO = 0;
        this.ddc = k.A(TbadkCoreApplication.m10getInst());
        this.ddb = new Point();
        this.ddg.setOnTouchListener(new h(this));
        this.bzO = com.baidu.adp.lib.util.a.w(TbadkCoreApplication.m10getInst());
        if (this.bzO == 0) {
            this.bzO = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.dde = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(int i, int i2) {
        this.dcV = SystemClock.elapsedRealtime();
        this.ddb.x = i;
        this.ddb.y = i2;
        if (this.ddd != null) {
            this.ddd.aS(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, int i2) {
        aV(this.ddb.x + i, (i2 - this.ddb.y) - this.bzO);
        if (this.ddd != null) {
            this.ddd.aR(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asI() {
        if (this.ddd != null) {
            if (SystemClock.elapsedRealtime() - this.dcV > 200) {
                this.ddd.asI();
            } else {
                this.ddd.asJ();
            }
        }
    }

    public void a(i iVar) {
        this.ddd = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams asM() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aU(int i, int i2) {
        if (this.ddi != null) {
            if (i >= 0) {
                this.ddi.x = i;
            }
            if (i2 >= 0) {
                this.ddi.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aV(int i, int i2) {
        if (this.ddi != null) {
            int i3 = this.ddc - i;
            if (i3 >= 0) {
                this.ddi.x = i3;
            }
            if (i2 >= 0) {
                this.ddi.y = i2;
            }
            if (this.ddh != null && this.ddg.getParent() != null) {
                this.ddh.updateViewLayout(this.ddg, this.ddi);
            }
        }
    }
}
