package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cvU = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void akl() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.cvU.cvT;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cvU.cvT;
        i = this.cvU.index;
        aVar2.delete(i);
    }
}
