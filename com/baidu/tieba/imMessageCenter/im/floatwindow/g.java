package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class g extends j {
    private int bbF;
    private long cuI;
    private Point cuO;
    protected final int cuP;
    private i cuQ;
    private boolean cuR;

    public g(View view) {
        super(view);
        this.cuR = true;
        this.bbF = 0;
        this.cuP = k.B(TbadkCoreApplication.m11getInst());
        this.cuO = new Point();
        this.cuT.setOnTouchListener(new h(this));
        this.bbF = com.baidu.adp.lib.util.a.x(TbadkCoreApplication.m11getInst());
        if (this.bbF == 0) {
            this.bbF = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.cuR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(int i, int i2) {
        this.cuI = SystemClock.elapsedRealtime();
        this.cuO.x = i;
        this.cuO.y = i2;
        if (this.cuQ != null) {
            this.cuQ.ay(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, int i2) {
        aB(this.cuO.x + i, (i2 - this.cuO.y) - this.bbF);
        if (this.cuQ != null) {
            this.cuQ.ax(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajG() {
        if (this.cuQ != null) {
            if (SystemClock.elapsedRealtime() - this.cuI > 200) {
                this.cuQ.ajG();
            } else {
                this.cuQ.ajH();
            }
        }
    }

    public void a(i iVar) {
        this.cuQ = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.j
    public WindowManager.LayoutParams ajK() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void aA(int i, int i2) {
        if (this.cuV != null) {
            if (i >= 0) {
                this.cuV.x = i;
            }
            if (i2 >= 0) {
                this.cuV.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aB(int i, int i2) {
        if (this.cuV != null) {
            int i3 = this.cuP - i;
            if (i3 >= 0) {
                this.cuV.x = i3;
            }
            if (i2 >= 0) {
                this.cuV.y = i2;
            }
            if (this.cuU != null && this.cuT.getParent() != null) {
                this.cuU.updateViewLayout(this.cuT, this.cuV);
            }
        }
    }
}
