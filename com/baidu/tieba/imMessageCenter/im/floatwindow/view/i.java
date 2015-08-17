package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bIv = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void Yk() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.bIv.bIu;
        if (aVar == null) {
            return;
        }
        aVar2 = this.bIv.bIu;
        i = this.bIv.index;
        aVar2.delete(i);
    }
}
