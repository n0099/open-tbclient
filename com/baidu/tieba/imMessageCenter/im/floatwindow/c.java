package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long bLB = 0;
    final /* synthetic */ b bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bLC = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void am(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE4;
        if (SystemClock.elapsedRealtime() - this.bLB <= 300) {
            return;
        }
        YE = this.bLC.YE();
        handler = this.bLC.handler;
        YE.b(handler);
        b bVar = this.bLC;
        YD = this.bLC.YD();
        e YL = YD.YL();
        YE2 = this.bLC.YE();
        a = bVar.a(YL, YE2.Zc());
        if (a) {
            YE4 = this.bLC.YE();
            YE4.Zd();
            return;
        }
        YE3 = this.bLC.YE();
        YE3.Ze();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void an(int i, int i2) {
        this.bLB = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void YI() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE2;
        Handler handler;
        b bVar = this.bLC;
        YD = this.bLC.YD();
        e YL = YD.YL();
        YE = this.bLC.YE();
        a = bVar.a(YL, YE.Zc());
        if (a) {
            this.bLC.dE(true);
        } else {
            YD2 = this.bLC.YD();
            YD2.YZ();
        }
        YE2 = this.bLC.YE();
        handler = this.bLC.handler;
        YE2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void YJ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a YD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e YE;
        Handler handler;
        YD = this.bLC.YD();
        if (!YD.YY()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bLC.bLo = false;
            YD2 = this.bLC.YD();
            YD2.b(point);
            YE = this.bLC.YE();
            handler = this.bLC.handler;
            YE.c(handler);
        }
    }
}
