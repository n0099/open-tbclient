package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a bIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bIb = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void en(int i) {
        int i2;
        a aVar = this.bIb;
        i2 = this.bIb.bHq;
        aVar.an(i2 - i, -1);
    }
}
