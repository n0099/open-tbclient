package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a daQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.daQ = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void arY() {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        this.daQ.daM = false;
        this.daQ.setTouchable(true);
        interfaceC0067a = this.daQ.cZW;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.daQ.cZW;
            interfaceC0067a2.arY();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.daQ;
        i = this.daQ.dae;
        aVar.aS(i - point.x, point.y);
    }
}
