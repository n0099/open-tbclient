package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long btr = 0;
    final /* synthetic */ b bts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bts = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void W(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV4;
        if (SystemClock.elapsedRealtime() - this.btr <= 300) {
            return;
        }
        VV = this.bts.VV();
        handler = this.bts.handler;
        VV.b(handler);
        b bVar = this.bts;
        VU = this.bts.VU();
        j Wc = VU.Wc();
        VV2 = this.bts.VV();
        a = bVar.a(Wc, VV2.Wt());
        if (a) {
            VV4 = this.bts.VV();
            VV4.Wu();
            return;
        }
        VV3 = this.bts.VV();
        VV3.Wv();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void X(int i, int i2) {
        this.btr = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void VZ() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV2;
        Handler handler;
        b bVar = this.bts;
        VU = this.bts.VU();
        j Wc = VU.Wc();
        VV = this.bts.VV();
        a = bVar.a(Wc, VV.Wt());
        if (a) {
            this.bts.du(true);
        } else {
            VU2 = this.bts.VU();
            VU2.Wq();
        }
        VV2 = this.bts.VV();
        handler = this.bts.handler;
        VV2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void Wa() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VU2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VV;
        Handler handler;
        VU = this.bts.VU();
        if (!VU.Wp()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20));
            this.bts.btd = false;
            VU2 = this.bts.VU();
            VU2.b(point);
            VV = this.bts.VV();
            handler = this.bts.handler;
            VV.c(handler);
        }
    }
}
