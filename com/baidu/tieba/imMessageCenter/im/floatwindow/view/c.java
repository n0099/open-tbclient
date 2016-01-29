package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a cjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cjW = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void agi() {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        this.cjW.cjS = false;
        this.cjW.setTouchable(true);
        interfaceC0067a = this.cjW.cje;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.cjW.cje;
            interfaceC0067a2.agi();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.cjW;
        i = this.cjW.cjm;
        aVar.aF(i - point.x, point.y);
    }
}
