package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    private long cZX = 0;
    final /* synthetic */ b cZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cZY = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aO(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS4;
        if (SystemClock.elapsedRealtime() - this.cZX <= 300) {
            return;
        }
        arS = this.cZY.arS();
        handler = this.cZY.handler;
        arS.b(handler);
        b bVar = this.cZY;
        arR = this.cZY.arR();
        e arZ = arR.arZ();
        arS2 = this.cZY.arS();
        a = bVar.a(arZ, arS2.asq());
        if (a) {
            arS4 = this.cZY.arS();
            arS4.asr();
            return;
        }
        arS3 = this.cZY.arS();
        arS3.ass();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void aP(int i, int i2) {
        this.cZX = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void arW() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS2;
        Handler handler;
        b bVar = this.cZY;
        arR = this.cZY.arR();
        e arZ = arR.arZ();
        arS = this.cZY.arS();
        a = bVar.a(arZ, arS.asq());
        if (a) {
            this.cZY.fS(true);
        } else {
            arR2 = this.cZY.arR();
            arR2.asn();
        }
        arS2 = this.cZY.arS();
        handler = this.cZY.handler;
        arS2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.i
    public void arX() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a arR2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.e arS;
        Handler handler;
        arR = this.cZY.arR();
        if (!arR.asm()) {
            Point point = new Point(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds30), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds20));
            this.cZY.cZK = false;
            arR2 = this.cZY.arR();
            arR2.b(point);
            arS = this.cZY.arS();
            handler = this.cZY.handler;
            arS.c(handler);
        }
    }
}
