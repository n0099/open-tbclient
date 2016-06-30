package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h dbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dbk = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void asz() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.dbk.dbj;
        if (aVar == null) {
            return;
        }
        aVar2 = this.dbk.dbj;
        i = this.dbk.index;
        aVar2.delete(i);
    }
}
