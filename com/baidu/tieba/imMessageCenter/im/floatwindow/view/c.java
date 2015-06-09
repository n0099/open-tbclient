package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.imMessageCenter.im.floatwindow.a.e {
    final /* synthetic */ a bul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bul = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void Wc() {
        e eVar;
        e eVar2;
        this.bul.buh = false;
        this.bul.setTouchable(true);
        eVar = this.bul.btr;
        if (eVar != null) {
            eVar2 = this.bul.btr;
            eVar2.Wc();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.bul;
        i = this.bul.btz;
        aVar.aa(i - point.x, point.y);
    }
}
