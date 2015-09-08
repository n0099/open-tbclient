package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long bHQ = 0;
    final /* synthetic */ b bHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bHR = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aj(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF4;
        if (SystemClock.elapsedRealtime() - this.bHQ <= 300) {
            return;
        }
        XF = this.bHR.XF();
        handler = this.bHR.handler;
        XF.b(handler);
        b bVar = this.bHR;
        XE = this.bHR.XE();
        e XM = XE.XM();
        XF2 = this.bHR.XF();
        a = bVar.a(XM, XF2.Yd());
        if (a) {
            XF4 = this.bHR.XF();
            XF4.Ye();
            return;
        }
        XF3 = this.bHR.XF();
        XF3.Yf();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ak(int i, int i2) {
        this.bHQ = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void XJ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF2;
        Handler handler;
        b bVar = this.bHR;
        XE = this.bHR.XE();
        e XM = XE.XM();
        XF = this.bHR.XF();
        a = bVar.a(XM, XF.Yd());
        if (a) {
            this.bHR.dC(true);
        } else {
            XE2 = this.bHR.XE();
            XE2.Ya();
        }
        XF2 = this.bHR.XF();
        handler = this.bHR.handler;
        XF2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void XK() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a XE2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e XF;
        Handler handler;
        XE = this.bHR.XE();
        if (!XE.XZ()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bHR.bHD = false;
            XE2 = this.bHR.XE();
            XE2.b(point);
            XF = this.bHR.XF();
            handler = this.bHR.handler;
            XF.c(handler);
        }
    }
}
