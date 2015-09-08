package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a bII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bII = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void ev(int i) {
        int i2;
        a aVar = this.bII;
        i2 = this.bII.bHX;
        aVar.an(i2 - i, -1);
    }
}
