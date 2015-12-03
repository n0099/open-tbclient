package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cbx = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void eI(int i) {
        int i2;
        a aVar = this.cbx;
        i2 = this.cbx.caM;
        aVar.as(i2 - i, -1);
    }
}
