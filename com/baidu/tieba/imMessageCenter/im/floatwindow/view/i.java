package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h ckr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ckr = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void agJ() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.ckr.ckq;
        if (aVar == null) {
            return;
        }
        aVar2 = this.ckr.ckq;
        i = this.ckr.index;
        aVar2.delete(i);
    }
}
