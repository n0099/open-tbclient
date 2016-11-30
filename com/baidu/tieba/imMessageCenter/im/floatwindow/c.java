package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long dvI = 0;
    final /* synthetic */ b dvJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dvJ = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aY(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO4;
        if (SystemClock.elapsedRealtime() - this.dvI <= 300) {
            return;
        }
        azO = this.dvJ.azO();
        handler = this.dvJ.handler;
        azO.b(handler);
        b bVar = this.dvJ;
        azN = this.dvJ.azN();
        e azV = azN.azV();
        azO2 = this.dvJ.azO();
        a = bVar.a(azV, azO2.aAl());
        if (a) {
            azO4 = this.dvJ.azO();
            azO4.aAm();
            return;
        }
        azO3 = this.dvJ.azO();
        azO3.aAn();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aZ(int i, int i2) {
        this.dvI = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void azS() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO2;
        Handler handler;
        b bVar = this.dvJ;
        azN = this.dvJ.azN();
        e azV = azN.azV();
        azO = this.dvJ.azO();
        a = bVar.a(azV, azO.aAl());
        if (a) {
            this.dvJ.gO(true);
        } else {
            azN2 = this.dvJ.azN();
            azN2.aAi();
        }
        azO2 = this.dvJ.azO();
        handler = this.dvJ.handler;
        azO2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void azT() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a azN2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e azO;
        Handler handler;
        azN = this.dvJ.azN();
        if (!azN.aAh()) {
            Point point = new Point(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds20));
            this.dvJ.dvv = false;
            azN2 = this.dvJ.azN();
            azN2.b(point);
            azO = this.dvJ.azO();
            handler = this.dvJ.handler;
            azO.c(handler);
        }
    }
}
