package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.graphics.Point;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements n {
    private long bts = 0;
    final /* synthetic */ b btt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.btt = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void W(int i, int i2) {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW;
        Handler handler;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW2;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW3;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW4;
        if (SystemClock.elapsedRealtime() - this.bts <= 300) {
            return;
        }
        VW = this.btt.VW();
        handler = this.btt.handler;
        VW.b(handler);
        b bVar = this.btt;
        VV = this.btt.VV();
        j Wd = VV.Wd();
        VW2 = this.btt.VW();
        a = bVar.a(Wd, VW2.Wu());
        if (a) {
            VW4 = this.btt.VW();
            VW4.Wv();
            return;
        }
        VW3 = this.btt.VW();
        VW3.Ww();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void X(int i, int i2) {
        this.bts = SystemClock.elapsedRealtime();
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void Wa() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW;
        boolean a;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW2;
        Handler handler;
        b bVar = this.btt;
        VV = this.btt.VV();
        j Wd = VV.Wd();
        VW = this.btt.VW();
        a = bVar.a(Wd, VW.Wu());
        if (a) {
            this.btt.du(true);
        } else {
            VV2 = this.btt.VV();
            VV2.Wr();
        }
        VW2 = this.btt.VW();
        handler = this.btt.handler;
        VW2.c(handler);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.n
    public void Wb() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.a VV2;
        com.baidu.tieba.imMessageCenter.im.floatwindow.view.f VW;
        Handler handler;
        VV = this.btt.VV();
        if (!VV.Wq()) {
            Point point = new Point(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20));
            this.btt.bte = false;
            VV2 = this.btt.VV();
            VV2.b(point);
            VW = this.btt.VW();
            handler = this.btt.handler;
            VW.c(handler);
        }
    }
}
