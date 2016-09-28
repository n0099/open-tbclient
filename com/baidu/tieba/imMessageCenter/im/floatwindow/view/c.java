package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a dqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dqS = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void axX() {
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        this.dqS.dqO = false;
        this.dqS.setTouchable(true);
        interfaceC0071a = this.dqS.dqa;
        if (interfaceC0071a != null) {
            interfaceC0071a2 = this.dqS.dqa;
            interfaceC0071a2.axX();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.dqS;
        i = this.dqS.dqi;
        aVar.bb(i - point.x, point.y);
    }
}
