package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a cfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cfx = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void acZ() {
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        this.cfx.cft = false;
        this.cfx.setTouchable(true);
        interfaceC0065a = this.cfx.ceF;
        if (interfaceC0065a != null) {
            interfaceC0065a2 = this.cfx.ceF;
            interfaceC0065a2.acZ();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.cfx;
        i = this.cfx.ceN;
        aVar.aE(i - point.x, point.y);
    }
}
