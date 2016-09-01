package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
import com.baidu.tieba.imMessageCenter.im.floatwindow.a.c;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements c.a {
    final /* synthetic */ a dpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dpv = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void axy() {
        a.InterfaceC0068a interfaceC0068a;
        a.InterfaceC0068a interfaceC0068a2;
        this.dpv.dpr = false;
        this.dpv.setTouchable(true);
        interfaceC0068a = this.dpv.doC;
        if (interfaceC0068a != null) {
            interfaceC0068a2 = this.dpv.doC;
            interfaceC0068a2.axy();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.c.a
    public void a(Point point) {
        int i;
        a aVar = this.dpv;
        i = this.dpv.doK;
        aVar.aZ(i - point.x, point.y);
    }
}
