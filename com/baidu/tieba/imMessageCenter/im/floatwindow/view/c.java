package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a bIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bIb = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void XJ() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.bIb.bHX = false;
        this.bIb.setTouchable(true);
        interfaceC0062a = this.bIb.bHi;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.bIb.bHi;
            interfaceC0062a2.XJ();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.bIb;
        i = this.bIb.bHq;
        aVar.an(i - point.x, point.y);
    }
}
