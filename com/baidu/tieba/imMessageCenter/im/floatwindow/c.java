package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long ceG = 0;
    final /* synthetic */ b ceH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ceH = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aA(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT4;
        if (SystemClock.elapsedRealtime() - this.ceG <= 300) {
            return;
        }
        acT = this.ceH.acT();
        handler = this.ceH.handler;
        acT.b(handler);
        b bVar = this.ceH;
        acS = this.ceH.acS();
        e ada = acS.ada();
        acT2 = this.ceH.acT();
        a = bVar.a(ada, acT2.adr());
        if (a) {
            acT4 = this.ceH.acT();
            acT4.ads();
            return;
        }
        acT3 = this.ceH.acT();
        acT3.adt();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aB(int i, int i2) {
        this.ceG = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void acX() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT2;
        Handler handler;
        b bVar = this.ceH;
        acS = this.ceH.acS();
        e ada = acS.ada();
        acT = this.ceH.acT();
        a = bVar.a(ada, acT.adr());
        if (a) {
            this.ceH.dZ(true);
        } else {
            acS2 = this.ceH.acS();
            acS2.ado();
        }
        acT2 = this.ceH.acT();
        handler = this.ceH.handler;
        acT2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void acY() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a acS2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e acT;
        Handler handler;
        acS = this.ceH.acS();
        if (!acS.adn()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds20));
            this.ceH.cet = false;
            acS2 = this.ceH.acS();
            acS2.b(point);
            acT = this.ceH.acT();
            handler = this.ceH.handler;
            acT.c(handler);
        }
    }
}
