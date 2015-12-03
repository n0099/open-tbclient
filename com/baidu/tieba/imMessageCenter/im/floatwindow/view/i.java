package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cbR = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void acr() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.cbR.cbQ;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cbR.cbQ;
        i = this.cbR.index;
        aVar2.delete(i);
    }
}
