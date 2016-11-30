package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h dwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dwT = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void aAu() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.dwT.dwS;
        if (aVar == null) {
            return;
        }
        aVar2 = this.dwT.dwS;
        i = this.dwT.index;
        aVar2.delete(i);
    }
}
