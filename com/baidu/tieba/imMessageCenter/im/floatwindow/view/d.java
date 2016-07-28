package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a ddN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.ddN = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void eN(int i) {
        int i2;
        a aVar = this.ddN;
        i2 = this.ddN.ddc;
        aVar.aV(i2 - i, -1);
    }
}
