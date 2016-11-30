package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a dwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dwz = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void azU() {
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        this.dwz.dwv = false;
        this.dwz.setTouchable(true);
        interfaceC0070a = this.dwz.dvH;
        if (interfaceC0070a != null) {
            interfaceC0070a2 = this.dwz.dvH;
            interfaceC0070a2.azU();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.dwz;
        i = this.dwz.dvP;
        aVar.bc(i - point.x, point.y);
    }
}
