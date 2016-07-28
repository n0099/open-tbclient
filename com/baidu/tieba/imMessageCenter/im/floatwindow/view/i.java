package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h deh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.deh = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void atl() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.deh.deg;
        if (aVar == null) {
            return;
        }
        aVar2 = this.deh.deg;
        i = this.deh.index;
        aVar2.delete(i);
    }
}
