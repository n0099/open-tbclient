package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a bLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bLN = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void Yt() {
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        this.bLN.bLJ = false;
        this.bLN.setTouchable(true);
        interfaceC0062a = this.bLN.bKU;
        if (interfaceC0062a != null) {
            interfaceC0062a2 = this.bLN.bKU;
            interfaceC0062a2.Yt();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.bLN;
        i = this.bLN.bLc;
        aVar.ao(i - point.x, point.y);
    }
}
