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
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj4;
        if (SystemClock.elapsedRealtime() - this.bLg <= 300) {
            return;
        }
        Yj = this.bLh.Yj();
        handler = this.bLh.handler;
        Yj.b(handler);
        b bVar = this.bLh;
        Yi = this.bLh.Yi();
        e Yq = Yi.Yq();
        Yj2 = this.bLh.Yj();
        a = bVar.a(Yq, Yj2.YH());
        if (a) {
            Yj4 = this.bLh.Yj();
            Yj4.YI();
            return;
        }
        Yj3 = this.bLh.Yj();
        Yj3.YJ();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void al(int i, int i2) {
        this.bLg = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Yn() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj2;
        Handler handler;
        b bVar = this.bLh;
        Yi = this.bLh.Yi();
        e Yq = Yi.Yq();
        Yj = this.bLh.Yj();
        a = bVar.a(Yq, Yj.YH());
        if (a) {
            this.bLh.dC(true);
        } else {
            Yi2 = this.bLh.Yi();
            Yi2.YE();
        }
        Yj2 = this.bLh.Yj();
        handler = this.bLh.handler;
        Yj2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void Yo() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a Yi2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e Yj;
        Handler handler;
        Yi = this.bLh.Yi();
        if (!Yi.YD()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds20));
            this.bLh.bKT = false;
            Yi2 = this.bLh.Yi();
            Yi2.b(point);
            Yj = this.bLh.Yj();
            handler = this.bLh.handler;
            Yj.c(handler);
        }
    }
}
