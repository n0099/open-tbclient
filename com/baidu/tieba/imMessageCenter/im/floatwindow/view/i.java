package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h dpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dpP = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void axZ() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.dpP.dpO;
        if (aVar == null) {
            return;
        }
        aVar2 = this.dpP.dpO;
        i = this.dpP.index;
        aVar2.delete(i);
    }
}
