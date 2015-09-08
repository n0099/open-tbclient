package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a bII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bII = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void XL() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.bII.bIE = false;
        this.bII.setTouchable(true);
        interfaceC0062a = this.bII.bHP;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.bII.bHP;
            interfaceC0062a2.XL();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.bII;
        i = this.bII.bHX;
        aVar.an(i - point.x, point.y);
    }
}
