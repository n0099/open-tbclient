package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long cjf = 0;
    final /* synthetic */ b cjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cjg = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aB(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc4;
        if (SystemClock.elapsedRealtime() - this.cjf <= 300) {
            return;
        }
        agc = this.cjg.agc();
        handler = this.cjg.handler;
        agc.b(handler);
        b bVar = this.cjg;
        agb = this.cjg.agb();
        e agj = agb.agj();
        agc2 = this.cjg.agc();
        a = bVar.a(agj, agc2.agA());
        if (a) {
            agc4 = this.cjg.agc();
            agc4.agB();
            return;
        }
        agc3 = this.cjg.agc();
        agc3.agC();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aC(int i, int i2) {
        this.cjf = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void agg() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc2;
        Handler handler;
        b bVar = this.cjg;
        agb = this.cjg.agb();
        e agj = agb.agj();
        agc = this.cjg.agc();
        a = bVar.a(agj, agc.agA());
        if (a) {
            this.cjg.eg(true);
        } else {
            agb2 = this.cjg.agb();
            agb2.agx();
        }
        agc2 = this.cjg.agc();
        handler = this.cjg.handler;
        agc2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void agh() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a agb2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e agc;
        Handler handler;
        agb = this.cjg.agb();
        if (!agb.agw()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds20));
            this.cjg.ciS = false;
            agb2 = this.cjg.agb();
            agb2.b(point);
            agc = this.cjg.agc();
            handler = this.cjg.handler;
            agc.c(handler);
        }
    }
}
