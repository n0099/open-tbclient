package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a dpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dpv = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void fb(int i) {
        int i2;
        a aVar = this.dpv;
        i2 = this.dpv.doK;
        aVar.aZ(i2 - i, -1);
    }
}
