package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long bqH = 0;
    final /* synthetic */ b bqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bqI = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void U(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE4;
        if (SystemClock.elapsedRealtime() - this.bqH <= 300) {
            return;
        }
        UE = this.bqI.UE();
        handler = this.bqI.handler;
        UE.b(handler);
        b bVar = this.bqI;
        UD = this.bqI.UD();
        j UL = UD.UL();
        UE2 = this.bqI.UE();
        a = bVar.a(UL, UE2.Vc());
        if (a) {
            UE4 = this.bqI.UE();
            UE4.Vd();
            return;
        }
        UE3 = this.bqI.UE();
        UE3.Ve();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void V(int i, int i2) {
        this.bqH = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void UI() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE2;
        Handler handler;
        b bVar = this.bqI;
        UD = this.bqI.UD();
        j UL = UD.UL();
        UE = this.bqI.UE();
        a = bVar.a(UL, UE.Vc());
        if (a) {
            this.bqI.di(true);
        } else {
            UD2 = this.bqI.UD();
            UD2.UZ();
        }
        UE2 = this.bqI.UE();
        handler = this.bqI.handler;
        UE2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void UJ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a UD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f UE;
        Handler handler;
        UD = this.bqI.UD();
        if (!UD.UY()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.ds20));
            this.bqI.bqu = false;
            UD2 = this.bqI.UD();
            UD2.b(point);
            UE = this.bqI.UE();
            handler = this.bqI.handler;
            UE.c(handler);
        }
    }
}
