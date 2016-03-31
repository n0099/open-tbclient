package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cuX = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void akd() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.cuX.cuW;
        if (aVar == null) {
            return;
        }
        aVar2 = this.cuX.cuW;
        i = this.cuX.index;
        aVar2.delete(i);
    }
}
