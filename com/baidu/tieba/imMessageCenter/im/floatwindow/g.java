package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aQz;
    private long bHQ;
    private Point bHW;
    protected final int bHX;
    private i bHY;
    private boolean bHZ;

    public g(View view) {
        super(view);
        this.bHZ = true;
        this.aQz = 0;
        this.bHX = k.K(TbadkCoreApplication.m411getInst());
        this.bHW = new Point();
        this.bIb.setOnTouchListener(new h(this));
        this.aQz = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aQz == 0) {
            this.aQz = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bHZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i, int i2) {
        this.bHQ = SystemClock.elapsedRealtime();
        this.bHW.x = i;
        this.bHW.y = i2;
        if (this.bHY != null) {
            this.bHY.ak(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i, int i2) {
        an(this.bHW.x + i, (i2 - this.bHW.y) - this.aQz);
        if (this.bHY != null) {
            this.bHY.aj(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        if (this.bHY != null) {
            if (SystemClock.elapsedRealtime() - this.bHQ > 200) {
                this.bHY.XJ();
            } else {
                this.bHY.XK();
            }
        }
    }

    public void a(i iVar) {
        this.bHY = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams XN() {
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
        if (this.bId != null) {
            if (i >= 0) {
                this.bId.x = i;
            }
            if (i2 >= 0) {
                this.bId.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(int i, int i2) {
        if (this.bId != null) {
            int i3 = this.bHX - i;
            if (i3 >= 0) {
                this.bId.x = i3;
            }
            if (i2 >= 0) {
                this.bId.y = i2;
            }
            if (this.bIc != null && this.bIb.getParent() != null) {
                this.bIc.updateViewLayout(this.bIb, this.bId);
            }
        }
    }
}
