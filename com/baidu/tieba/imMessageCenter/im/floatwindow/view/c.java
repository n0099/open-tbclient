package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.imMessageCenter.im.floatwindow.a.e {
    final /* synthetic */ a buk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.buk = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void Wb() {
        e eVar;
        e eVar2;
        this.buk.bug = false;
        this.buk.setTouchable(true);
        eVar = this.buk.btq;
        if (eVar != null) {
            eVar2 = this.buk.btq;
            eVar2.Wb();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.buk;
        i = this.buk.bty;
        aVar.aa(i - point.x, point.y);
    }
}
