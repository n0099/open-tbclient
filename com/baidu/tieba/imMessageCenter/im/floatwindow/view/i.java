package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h bMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bMs = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void YQ() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.bMs.bMr;
        if (aVar == null) {
            return;
        }
        aVar2 = this.bMs.bMr;
        i = this.bMs.index;
        aVar2.delete(i);
    }
}
