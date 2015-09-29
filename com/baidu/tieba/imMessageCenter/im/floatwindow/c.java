package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long bKV = 0;
    final /* synthetic */ b bKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bKW = bVar;
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
        if (SystemClock.elapsedRealtime() - this.bKV <= 300) {
            return;
        }
        Yn = this.bKW.Yn();
        handler = this.bKW.handler;
        Yn.b(handler);
        b bVar = this.bKW;
        Ym = this.bKW.Ym();
        e Yu = Ym.Yu();
        Yn2 = this.bKW.Yn();
        a = bVar.a(Yu, Yn2.YL());
        if (a) {
            Yn4 = this.bKW.Yn();
            Yn4.YM();
            return;
        }
        Yn3 = this.bKW.Yn();
        Yn3.YN();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void al(int i, int i2) {
        this.bKV = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Yr() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn2;
        Handler handler;
        b bVar = this.bKW;
        Ym = this.bKW.Ym();
        e Yu = Ym.Yu();
        Yn = this.bKW.Yn();
        a = bVar.a(Yu, Yn.YL());
        if (a) {
            this.bKW.dC(true);
        } else {
            Ym2 = this.bKW.Ym();
            Ym2.YI();
        }
        Yn2 = this.bKW.Yn();
        handler = this.bKW.handler;
        Yn2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Ys() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Ym2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yn;
        Handler handler;
        Ym = this.bKW.Ym();
        if (!Ym.YH()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bKW.bKI = false;
            Ym2 = this.bKW.Ym();
            Ym2.b(point);
            Yn = this.bKW.Yn();
            handler = this.bKW.handler;
            Yn.c(handler);
        }
    }
}
