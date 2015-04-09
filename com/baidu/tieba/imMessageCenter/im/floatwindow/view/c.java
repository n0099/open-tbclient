package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.graphics.Point;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.imMessageCenter.im.floatwindow.a.e {
    final /* synthetic */ a bry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bry = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void UK() {
        e eVar;
        e eVar2;
        this.bry.brv = false;
        this.bry.setTouchable(true);
        eVar = this.bry.bqG;
        if (eVar != null) {
            eVar2 = this.bry.bqG;
            eVar2.UK();
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e
    public void a(Point point) {
        int i;
        a aVar = this.bry;
        i = this.bry.bqO;
        aVar.Y(i - point.x, point.y);
    }
}
