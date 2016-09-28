package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.a {
    final /* synthetic */ a dqS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dqS = aVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.a.e.a
    public void fa(int i) {
        int i2;
        a aVar = this.dqS;
        i2 = this.dqS.dqi;
        aVar.bb(i2 - i, -1);
    }
}
