package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long bHj = 0;
    final /* synthetic */ b bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bHk = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aj(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD4;
        if (SystemClock.elapsedRealtime() - this.bHj <= 300) {
            return;
        }
        XD = this.bHk.XD();
        handler = this.bHk.handler;
        XD.b(handler);
        b bVar = this.bHk;
        XC = this.bHk.XC();
        e XK = XC.XK();
        XD2 = this.bHk.XD();
        a = bVar.a(XK, XD2.Yb());
        if (a) {
            XD4 = this.bHk.XD();
            XD4.Yc();
            return;
        }
        XD3 = this.bHk.XD();
        XD3.Yd();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ak(int i, int i2) {
        this.bHj = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void XH() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD2;
        Handler handler;
        b bVar = this.bHk;
        XC = this.bHk.XC();
        e XK = XC.XK();
        XD = this.bHk.XD();
        a = bVar.a(XK, XD.Yb());
        if (a) {
            this.bHk.dx(true);
        } else {
            XC2 = this.bHk.XC();
            XC2.XY();
        }
        XD2 = this.bHk.XD();
        handler = this.bHk.handler;
        XD2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void XI() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XC2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XD;
        Handler handler;
        XC = this.bHk.XC();
        if (!XC.XX()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bHk.bGW = false;
            XC2 = this.bHk.XC();
            XC2.b(point);
            XD = this.bHk.XD();
            handler = this.bHk.handler;
            XD.c(handler);
        }
    }
}
