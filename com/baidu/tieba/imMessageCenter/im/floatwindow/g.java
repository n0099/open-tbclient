package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aPO;
    private long bLB;
    private Point bLH;
    protected final int bLI;
    private i bLJ;
    private boolean bLK;

    public g(View view) {
        super(view);
        this.bLK = true;
        this.aPO = 0;
        this.bLI = k.K(TbadkCoreApplication.m411getInst());
        this.bLH = new Point();
        this.bLM.setOnTouchListener(new h(this));
        this.aPO = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aPO == 0) {
            this.aPO = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.bLK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(int i, int i2) {
        this.bLB = SystemClock.elapsedRealtime();
        this.bLH.x = i;
        this.bLH.y = i2;
        if (this.bLJ != null) {
            this.bLJ.an(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(int i, int i2) {
        aq(this.bLH.x + i, (i2 - this.bLH.y) - this.aPO);
        if (this.bLJ != null) {
            this.bLJ.am(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YI() {
        if (this.bLJ != null) {
            if (SystemClock.elapsedRealtime() - this.bLB > 200) {
                this.bLJ.YI();
            } else {
                this.bLJ.YJ();
            }
        }
    }

    public void a(i iVar) {
        this.bLJ = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams YM() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void ap(int i, int i2) {
        if (this.bLO != null) {
            if (i >= 0) {
                this.bLO.x = i;
            }
            if (i2 >= 0) {
                this.bLO.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aq(int i, int i2) {
        if (this.bLO != null) {
            int i3 = this.bLI - i;
            if (i3 >= 0) {
                this.bLO.x = i3;
            }
            if (i2 >= 0) {
                this.bLO.y = i2;
            }
            if (this.bLN != null && this.bLM.getParent() != null) {
                this.bLN.updateViewLayout(this.bLM, this.bLO);
            }
        }
    }
}
