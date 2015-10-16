package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long bLg = 0;
    final /* synthetic */ b bLh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bLh = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ak(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn4;
        if (SystemClock.elapsedRealtime() - this.bLg <= 300) {
            return;
        }
        Yn = this.bLh.Yn();
        handler = this.bLh.handler;
        Yn.b(handler);
        b bVar = this.bLh;
        Ym = this.bLh.Ym();
        e Yu = Ym.Yu();
        Yn2 = this.bLh.Yn();
        a = bVar.a(Yu, Yn2.YL());
        if (a) {
            Yn4 = this.bLh.Yn();
            Yn4.YM();
            return;
        }
        Yn3 = this.bLh.Yn();
        Yn3.YN();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void al(int i, int i2) {
        this.bLg = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Yr() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn2;
        Handler handler;
        b bVar = this.bLh;
        Ym = this.bLh.Ym();
        e Yu = Ym.Yu();
        Yn = this.bLh.Yn();
        a = bVar.a(Yu, Yn.YL());
        if (a) {
            this.bLh.dC(true);
        } else {
            Ym2 = this.bLh.Ym();
            Ym2.YI();
        }
        Yn2 = this.bLh.Yn();
        handler = this.bLh.handler;
        Yn2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Ys() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn;
        Handler handler;
        Ym = this.bLh.Ym();
        if (!Ym.YH()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bLh.bKT = false;
            Ym2 = this.bLh.Ym();
            Ym2.b(point);
            Yn = this.bLh.Yn();
            handler = this.bLh.handler;
            Yn.c(handler);
        }
    }
}
