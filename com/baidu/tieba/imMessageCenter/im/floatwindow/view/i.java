package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h bMN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bMN = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void Zl() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.bMN.bMM;
        if (aVar == null) {
            return;
        }
        aVar2 = this.bMN.bMM;
        i = this.bMN.index;
        aVar2.delete(i);
    }
}
