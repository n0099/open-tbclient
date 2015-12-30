package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aYR;
    private long ceG;
    private Point ceM;
    protected final int ceN;
    private i ceO;
    private boolean ceP;

    public g(View view) {
        super(view);
        this.ceP = true;
        this.aYR = 0;
        this.ceN = k.K(TbadkCoreApplication.m411getInst());
        this.ceM = new Point();
        this.ceR.setOnTouchListener(new h(this));
        this.aYR = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aYR == 0) {
            this.aYR = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.ceP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, int i2) {
        this.ceG = SystemClock.elapsedRealtime();
        this.ceM.x = i;
        this.ceM.y = i2;
        if (this.ceO != null) {
            this.ceO.aB(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, int i2) {
        aE(this.ceM.x + i, (i2 - this.ceM.y) - this.aYR);
        if (this.ceO != null) {
            this.ceO.aA(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acX() {
        if (this.ceO != null) {
            if (SystemClock.elapsedRealtime() - this.ceG > 200) {
                this.ceO.acX();
            } else {
                this.ceO.acY();
            }
        }
    }

    public void a(i iVar) {
        this.ceO = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams adb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aD(int i, int i2) {
        if (this.ceT != null) {
            if (i >= 0) {
                this.ceT.x = i;
            }
            if (i2 >= 0) {
                this.ceT.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aE(int i, int i2) {
        if (this.ceT != null) {
            int i3 = this.ceN - i;
            if (i3 >= 0) {
                this.ceT.x = i3;
            }
            if (i2 >= 0) {
                this.ceT.y = i2;
            }
            if (this.ceS != null && this.ceR.getParent() != null) {
                this.ceS.updateViewLayout(this.ceR, this.ceT);
            }
        }
    }
}
