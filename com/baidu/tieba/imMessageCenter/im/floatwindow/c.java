package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long ctK = 0;
    final /* synthetic */ b ctL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ctL = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ay(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw4;
        if (SystemClock.elapsedRealtime() - this.ctK <= 300) {
            return;
        }
        ajw = this.ctL.ajw();
        handler = this.ctL.handler;
        ajw.b(handler);
        b bVar = this.ctL;
        ajv = this.ctL.ajv();
        e ajD = ajv.ajD();
        ajw2 = this.ctL.ajw();
        a = bVar.a(ajD, ajw2.ajU());
        if (a) {
            ajw4 = this.ctL.ajw();
            ajw4.ajV();
            return;
        }
        ajw3 = this.ctL.ajw();
        ajw3.ajW();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void az(int i, int i2) {
        this.ctK = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajA() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw2;
        Handler handler;
        b bVar = this.ctL;
        ajv = this.ctL.ajv();
        e ajD = ajv.ajD();
        ajw = this.ctL.ajw();
        a = bVar.a(ajD, ajw.ajU());
        if (a) {
            this.ctL.eC(true);
        } else {
            ajv2 = this.ctL.ajv();
            ajv2.ajR();
        }
        ajw2 = this.ctL.ajw();
        handler = this.ctL.handler;
        ajw2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void ajB() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a ajv2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e ajw;
        Handler handler;
        ajv = this.ctL.ajv();
        if (!ajv.ajQ()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds20));
            this.ctL.ctx = false;
            ajv2 = this.ctL.ajv();
            ajv2.b(point);
            ajw = this.ctL.ajw();
            handler = this.ctL.handler;
            ajw.c(handler);
        }
    }
}
