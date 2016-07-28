package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long dcV = 0;
    final /* synthetic */ b dcW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dcW = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aR(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE4;
        if (SystemClock.elapsedRealtime() - this.dcV <= 300) {
            return;
        }
        asE = this.dcW.asE();
        handler = this.dcW.handler;
        asE.b(handler);
        b bVar = this.dcW;
        asD = this.dcW.asD();
        e asL = asD.asL();
        asE2 = this.dcW.asE();
        a = bVar.a(asL, asE2.atc());
        if (a) {
            asE4 = this.dcW.asE();
            asE4.atd();
            return;
        }
        asE3 = this.dcW.asE();
        asE3.ate();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aS(int i, int i2) {
        this.dcV = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void asI() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE2;
        Handler handler;
        b bVar = this.dcW;
        asD = this.dcW.asD();
        e asL = asD.asL();
        asE = this.dcW.asE();
        a = bVar.a(asL, asE.atc());
        if (a) {
            this.dcW.fV(true);
        } else {
            asD2 = this.dcW.asD();
            asD2.asZ();
        }
        asE2 = this.dcW.asE();
        handler = this.dcW.handler;
        asE2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void asJ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a asD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e asE;
        Handler handler;
        asD = this.dcW.asD();
        if (!asD.asY()) {
            Point point = new Point(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds30), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds20));
            this.dcW.dcI = false;
            asD2 = this.dcW.asD();
            asD2.b(point);
            asE = this.dcW.asE();
            handler = this.dcW.handler;
            asE.c(handler);
        }
    }
}
