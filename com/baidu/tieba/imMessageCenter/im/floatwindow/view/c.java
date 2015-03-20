package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.imMessageCenter.im.floatwindow.a.e {
    final /* synthetic */ a bri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bri = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void Ux() {
        e eVar;
        e eVar2;
        this.bri.brf = false;
        this.bri.setTouchable(true);
        eVar = this.bri.bqq;
        if (eVar != null) {
            eVar2 = this.bri.bqq;
            eVar2.Ux();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.bri;
        i = this.bri.bqy;
        aVar.Y(i - point.x, point.y);
    }
}
