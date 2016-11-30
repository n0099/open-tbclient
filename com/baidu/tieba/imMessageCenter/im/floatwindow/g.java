package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bOk;
    private long dvI;
    private Point dvO;
    protected final int dvP;
    private i dvQ;
    private boolean dvR;

    public g(View view) {
        super(view);
        this.dvR = true;
        this.bOk = 0;
        this.dvP = k.K(TbadkCoreApplication.m9getInst());
        this.dvO = new Point();
        this.dvT.setOnTouchListener(new h(this));
        this.bOk = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m9getInst());
        if (this.bOk == 0) {
            this.bOk = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.dvR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, int i2) {
        this.dvI = SystemClock.elapsedRealtime();
        this.dvO.x = i;
        this.dvO.y = i2;
        if (this.dvQ != null) {
            this.dvQ.aZ(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, int i2) {
        bc(this.dvO.x + i, (i2 - this.dvO.y) - this.bOk);
        if (this.dvQ != null) {
            this.dvQ.aY(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azS() {
        if (this.dvQ != null) {
            if (SystemClock.elapsedRealtime() - this.dvI > 200) {
                this.dvQ.azS();
            } else {
                this.dvQ.azT();
            }
        }
    }

    public void a(i iVar) {
        this.dvQ = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams azW() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void bb(int i, int i2) {
        if (this.dvV != null) {
            if (i >= 0) {
                this.dvV.x = i;
            }
            if (i2 >= 0) {
                this.dvV.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bc(int i, int i2) {
        if (this.dvV != null) {
            int i3 = this.dvP - i;
            if (i3 >= 0) {
                this.dvV.x = i3;
            }
            if (i2 >= 0) {
                this.dvV.y = i2;
            }
            if (this.dvU != null && this.dvT.getParent() != null) {
                this.dvU.updateViewLayout(this.dvT, this.dvV);
            }
        }
    }
}
