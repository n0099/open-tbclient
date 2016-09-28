package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long dqb = 0;
    final /* synthetic */ b dqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dqc = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aX(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR4;
        if (SystemClock.elapsedRealtime() - this.dqb <= 300) {
            return;
        }
        axR = this.dqc.axR();
        handler = this.dqc.handler;
        axR.b(handler);
        b bVar = this.dqc;
        axQ = this.dqc.axQ();
        e axY = axQ.axY();
        axR2 = this.dqc.axR();
        a = bVar.a(axY, axR2.ayo());
        if (a) {
            axR4 = this.dqc.axR();
            axR4.ayp();
            return;
        }
        axR3 = this.dqc.axR();
        axR3.ayq();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aY(int i, int i2) {
        this.dqb = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void axV() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR2;
        Handler handler;
        b bVar = this.dqc;
        axQ = this.dqc.axQ();
        e axY = axQ.axY();
        axR = this.dqc.axR();
        a = bVar.a(axY, axR.ayo());
        if (a) {
            this.dqc.gu(true);
        } else {
            axQ2 = this.dqc.axQ();
            axQ2.ayl();
        }
        axR2 = this.dqc.axR();
        handler = this.dqc.handler;
        axR2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void axW() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axQ2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axR;
        Handler handler;
        axQ = this.dqc.axQ();
        if (!axQ.ayk()) {
            Point point = new Point(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds20));
            this.dqc.dpO = false;
            axQ2 = this.dqc.axQ();
            axQ2.b(point);
            axR = this.dqc.axR();
            handler = this.dqc.handler;
            axR.c(handler);
        }
    }
}
