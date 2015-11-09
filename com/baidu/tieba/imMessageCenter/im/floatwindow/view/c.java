package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a bMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bMt = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void YK() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.bMt.bMp = false;
        this.bMt.setTouchable(true);
        interfaceC0062a = this.bMt.bLA;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.bMt.bLA;
            interfaceC0062a2.YK();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.bMt;
        i = this.bMt.bLI;
        aVar.aq(i - point.x, point.y);
    }
}
