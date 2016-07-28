package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a ddN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ddN = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void asK() {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        this.ddN.ddJ = false;
        this.ddN.setTouchable(true);
        interfaceC0067a = this.ddN.dcU;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.ddN.dcU;
            interfaceC0067a2.asK();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.ddN;
        i = this.ddN.ddc;
        aVar.aV(i - point.x, point.y);
    }
}
