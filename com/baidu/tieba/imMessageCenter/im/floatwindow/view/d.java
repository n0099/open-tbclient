package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a cfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cfx = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void eC(int i) {
        int i2;
        a aVar = this.cfx;
        i2 = this.cfx.ceN;
        aVar.aE(i2 - i, -1);
    }
}
