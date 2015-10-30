package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bLY = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void Yp() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.bLY.bLU = false;
        this.bLY.setTouchable(true);
        interfaceC0062a = this.bLY.bLf;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.bLY.bLf;
            interfaceC0062a2.Yp();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.bLY;
        i = this.bLY.bLn;
        aVar.ao(i - point.x, point.y);
    }
}
