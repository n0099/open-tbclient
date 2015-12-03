package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int aUR;
    private long caF;
    private Point caL;
    protected final int caM;
    private i caN;
    private boolean caO;

    public g(View view) {
        super(view);
        this.caO = true;
        this.aUR = 0;
        this.caM = k.K(TbadkCoreApplication.m411getInst());
        this.caL = new Point();
        this.caQ.setOnTouchListener(new h(this));
        this.aUR = com.baidu.adp.lib.util.a.G(TbadkCoreApplication.m411getInst());
        if (this.aUR == 0) {
            this.aUR = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.caO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, int i2) {
        this.caF = SystemClock.elapsedRealtime();
        this.caL.x = i;
        this.caL.y = i2;
        if (this.caN != null) {
            this.caN.ap(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(int i, int i2) {
        as(this.caL.x + i, (i2 - this.caL.y) - this.aUR);
        if (this.caN != null) {
            this.caN.ao(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abO() {
        if (this.caN != null) {
            if (SystemClock.elapsedRealtime() - this.caF > 200) {
                this.caN.abO();
            } else {
                this.caN.abP();
            }
        }
    }

    public void a(i iVar) {
        this.caN = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams abS() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void ar(int i, int i2) {
        if (this.caS != null) {
            if (i >= 0) {
                this.caS.x = i;
            }
            if (i2 >= 0) {
                this.caS.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void as(int i, int i2) {
        if (this.caS != null) {
            int i3 = this.caM - i;
            if (i3 >= 0) {
                this.caS.x = i3;
            }
            if (i2 >= 0) {
                this.caS.y = i2;
            }
            if (this.caR != null && this.caQ.getParent() != null) {
                this.caR.updateViewLayout(this.caQ, this.caS);
            }
        }
    }
}
