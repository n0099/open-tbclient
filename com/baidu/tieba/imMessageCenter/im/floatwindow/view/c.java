package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cuC = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void ajC() {
        a.InterfaceC0068a interfaceC0068a;
        a.InterfaceC0068a interfaceC0068a2;
        this.cuC.cuy = false;
        this.cuC.setTouchable(true);
        interfaceC0068a = this.cuC.ctJ;
        if (interfaceC0068a != null) {
            interfaceC0068a2 = this.cuC.ctJ;
            interfaceC0068a2.ajC();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.cuC;
        i = this.cuC.ctR;
        aVar.aC(i - point.x, point.y);
    }
}
