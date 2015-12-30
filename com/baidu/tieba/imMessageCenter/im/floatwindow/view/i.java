package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h cfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cfR = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void adA() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.cfR.cfQ;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cfR.cfQ;
        i = this.cfR.index;
        aVar2.delete(i);
    }
}
