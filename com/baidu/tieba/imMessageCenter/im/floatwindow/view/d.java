package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a cjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cjW = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void eW(int i) {
        int i2;
        a aVar = this.cjW;
        i2 = this.cjW.cjm;
        aVar.aF(i2 - i, -1);
    }
}
