package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h bMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bMh = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void YU() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.bMh.bMg;
        if (aVar == null) {
            return;
        }
        aVar2 = this.bMh.bMg;
        i = this.bMh.index;
        aVar2.delete(i);
    }
}
