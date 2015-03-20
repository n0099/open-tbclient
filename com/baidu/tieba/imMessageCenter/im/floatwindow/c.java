package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long bqr = 0;
    final /* synthetic */ b bqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bqs = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void U(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur4;
        if (SystemClock.elapsedRealtime() - this.bqr <= 300) {
            return;
        }
        Ur = this.bqs.Ur();
        handler = this.bqs.handler;
        Ur.b(handler);
        b bVar = this.bqs;
        Uq = this.bqs.Uq();
        j Uy = Uq.Uy();
        Ur2 = this.bqs.Ur();
        a = bVar.a(Uy, Ur2.UP());
        if (a) {
            Ur4 = this.bqs.Ur();
            Ur4.UQ();
            return;
        }
        Ur3 = this.bqs.Ur();
        Ur3.UR();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void V(int i, int i2) {
        this.bqr = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void Uv() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur2;
        Handler handler;
        b bVar = this.bqs;
        Uq = this.bqs.Uq();
        j Uy = Uq.Uy();
        Ur = this.bqs.Ur();
        a = bVar.a(Uy, Ur.UP());
        if (a) {
            this.bqs.dk(true);
        } else {
            Uq2 = this.bqs.Uq();
            Uq2.UM();
        }
        Ur2 = this.bqs.Ur();
        handler = this.bqs.handler;
        Ur2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void Uw() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Uq2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f Ur;
        Handler handler;
        Uq = this.bqs.Uq();
        if (!Uq.UL()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds20));
            this.bqs.bqe = false;
            Uq2 = this.bqs.Uq();
            Uq2.b(point);
            Ur = this.bqs.Ur();
            handler = this.bqs.handler;
            Ur.c(handler);
        }
    }
}
