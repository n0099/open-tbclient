package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cbx = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void abQ() {
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        this.cbx.cbt = false;
        this.cbx.setTouchable(true);
        interfaceC0070a = this.cbx.caE;
        if (interfaceC0070a != null) {
            interfaceC0070a2 = this.cbx.caE;
            interfaceC0070a2.abQ();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.cbx;
        i = this.cbx.caM;
        aVar.as(i - point.x, point.y);
    }
}
