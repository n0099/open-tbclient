package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long cuI = 0;
    final /* synthetic */ b cuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cuJ = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ax(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE4;
        if (SystemClock.elapsedRealtime() - this.cuI <= 300) {
            return;
        }
        ajE = this.cuJ.ajE();
        handler = this.cuJ.handler;
        ajE.b(handler);
        b bVar = this.cuJ;
        ajD = this.cuJ.ajD();
        e ajL = ajD.ajL();
        ajE2 = this.cuJ.ajE();
        a = bVar.a(ajL, ajE2.akc());
        if (a) {
            ajE4 = this.cuJ.ajE();
            ajE4.akd();
            return;
        }
        ajE3 = this.cuJ.ajE();
        ajE3.ake();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ay(int i, int i2) {
        this.cuI = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajI() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE2;
        Handler handler;
        b bVar = this.cuJ;
        ajD = this.cuJ.ajD();
        e ajL = ajD.ajL();
        ajE = this.cuJ.ajE();
        a = bVar.a(ajL, ajE.akc());
        if (a) {
            this.cuJ.fe(true);
        } else {
            ajD2 = this.cuJ.ajD();
            ajD2.ajZ();
        }
        ajE2 = this.cuJ.ajE();
        handler = this.cuJ.handler;
        ajE2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajJ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajD;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajD2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajE;
        Handler handler;
        ajD = this.cuJ.ajD();
        if (!ajD.ajY()) {
            Point point = new Point(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds20));
            this.cuJ.cuv = false;
            ajD2 = this.cuJ.ajD();
            ajD2.b(point);
            ajE = this.cuJ.ajE();
            handler = this.cuJ.handler;
            ajE.c(handler);
        }
    }
}
