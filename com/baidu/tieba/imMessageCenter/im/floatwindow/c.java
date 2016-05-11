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
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC4;
        if (SystemClock.elapsedRealtime() - this.cuI <= 300) {
            return;
        }
        ajC = this.cuJ.ajC();
        handler = this.cuJ.handler;
        ajC.b(handler);
        b bVar = this.cuJ;
        ajB = this.cuJ.ajB();
        e ajJ = ajB.ajJ();
        ajC2 = this.cuJ.ajC();
        a = bVar.a(ajJ, ajC2.aka());
        if (a) {
            ajC4 = this.cuJ.ajC();
            ajC4.akb();
            return;
        }
        ajC3 = this.cuJ.ajC();
        ajC3.akc();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ay(int i, int i2) {
        this.cuI = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajG() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC2;
        Handler handler;
        b bVar = this.cuJ;
        ajB = this.cuJ.ajB();
        e ajJ = ajB.ajJ();
        ajC = this.cuJ.ajC();
        a = bVar.a(ajJ, ajC.aka());
        if (a) {
            this.cuJ.fe(true);
        } else {
            ajB2 = this.cuJ.ajB();
            ajB2.ajX();
        }
        ajC2 = this.cuJ.ajC();
        handler = this.cuJ.handler;
        ajC2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajH() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajB2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajC;
        Handler handler;
        ajB = this.cuJ.ajB();
        if (!ajB.ajW()) {
            Point point = new Point(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds20));
            this.cuJ.cuv = false;
            ajB2 = this.cuJ.ajB();
            ajB2.b(point);
            ajC = this.cuJ.ajC();
            handler = this.cuJ.handler;
            ajC.c(handler);
        }
    }
}
