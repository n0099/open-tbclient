package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long doD = 0;
    final /* synthetic */ b doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.doE = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aV(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs4;
        if (SystemClock.elapsedRealtime() - this.doD <= 300) {
            return;
        }
        axs = this.doE.axs();
        handler = this.doE.handler;
        axs.b(handler);
        b bVar = this.doE;
        axr = this.doE.axr();
        e axz = axr.axz();
        axs2 = this.doE.axs();
        a = bVar.a(axz, axs2.axQ());
        if (a) {
            axs4 = this.doE.axs();
            axs4.axR();
            return;
        }
        axs3 = this.doE.axs();
        axs3.axS();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aW(int i, int i2) {
        this.doD = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void axw() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs2;
        Handler handler;
        b bVar = this.doE;
        axr = this.doE.axr();
        e axz = axr.axz();
        axs = this.doE.axs();
        a = bVar.a(axz, axs.axQ());
        if (a) {
            this.doE.gr(true);
        } else {
            axr2 = this.doE.axr();
            axr2.axN();
        }
        axs2 = this.doE.axs();
        handler = this.doE.handler;
        axs2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void axx() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a axr2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e axs;
        Handler handler;
        axr = this.doE.axr();
        if (!axr.axM()) {
            Point point = new Point(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds20));
            this.doE.doq = false;
            axr2 = this.doE.axr();
            axr2.b(point);
            axs = this.doE.axs();
            handler = this.doE.handler;
            axs.c(handler);
        }
    }
}
