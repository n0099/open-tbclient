package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bLq;
    private long doD;
    private Point doJ;
    protected final int doK;
    private i doL;
    private boolean doM;

    public g(View view) {
        super(view);
        this.doM = true;
        this.bLq = 0;
        this.doK = k.K(TbadkCoreApplication.m9getInst());
        this.doJ = new Point();
        this.doO.setOnTouchListener(new h(this));
        this.bLq = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m9getInst());
        if (this.bLq == 0) {
            this.bLq = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.doM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, int i2) {
        this.doD = SystemClock.elapsedRealtime();
        this.doJ.x = i;
        this.doJ.y = i2;
        if (this.doL != null) {
            this.doL.aW(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i, int i2) {
        aZ(this.doJ.x + i, (i2 - this.doJ.y) - this.bLq);
        if (this.doL != null) {
            this.doL.aV(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axw() {
        if (this.doL != null) {
            if (SystemClock.elapsedRealtime() - this.doD > 200) {
                this.doL.axw();
            } else {
                this.doL.axx();
            }
        }
    }

    public void a(i iVar) {
        this.doL = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams axA() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aY(int i, int i2) {
        if (this.doQ != null) {
            if (i >= 0) {
                this.doQ.x = i;
            }
            if (i2 >= 0) {
                this.doQ.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZ(int i, int i2) {
        if (this.doQ != null) {
            int i3 = this.doK - i;
            if (i3 >= 0) {
                this.doQ.x = i3;
            }
            if (i2 >= 0) {
                this.doQ.y = i2;
            }
            if (this.doP != null && this.doO.getParent() != null) {
                this.doP.updateViewLayout(this.doO, this.doQ);
            }
        }
    }
}
