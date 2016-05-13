package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a cvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cvz = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void ajK() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.cvz.cvv = false;
        this.cvz.setTouchable(true);
        interfaceC0062a = this.cvz.cuH;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.cvz.cuH;
            interfaceC0062a2.ajK();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.cvz;
        i = this.cvz.cuP;
        aVar.aB(i - point.x, point.y);
    }
}
