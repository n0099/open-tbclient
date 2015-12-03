package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long caF = 0;
    final /* synthetic */ b caG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.caG = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ao(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK4;
        if (SystemClock.elapsedRealtime() - this.caF <= 300) {
            return;
        }
        abK = this.caG.abK();
        handler = this.caG.handler;
        abK.b(handler);
        b bVar = this.caG;
        abJ = this.caG.abJ();
        e abR = abJ.abR();
        abK2 = this.caG.abK();
        a = bVar.a(abR, abK2.aci());
        if (a) {
            abK4 = this.caG.abK();
            abK4.acj();
            return;
        }
        abK3 = this.caG.abK();
        abK3.ack();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ap(int i, int i2) {
        this.caF = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void abO() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK2;
        Handler handler;
        b bVar = this.caG;
        abJ = this.caG.abJ();
        e abR = abJ.abR();
        abK = this.caG.abK();
        a = bVar.a(abR, abK.aci());
        if (a) {
            this.caG.dZ(true);
        } else {
            abJ2 = this.caG.abJ();
            abJ2.acf();
        }
        abK2 = this.caG.abK();
        handler = this.caG.handler;
        abK2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void abP() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a abJ2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e abK;
        Handler handler;
        abJ = this.caG.abJ();
        if (!abJ.ace()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds20));
            this.caG.cas = false;
            abJ2 = this.caG.abJ();
            abJ2.b(point);
            abK = this.caG.abK();
            handler = this.caG.handler;
            abK.c(handler);
        }
    }
}
