package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.imMessageCenter.im.floatwindow.view.FloatingPersonalChatView;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.a {
    final /* synthetic */ h drm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.drm = hVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.h.a
    public void ayx() {
        FloatingPersonalChatView.a aVar;
        FloatingPersonalChatView.a aVar2;
        int i;
        aVar = this.drm.drl;
        if (aVar == null) {
            return;
        }
        aVar2 = this.drm.drl;
        i = this.drm.index;
        aVar2.delete(i);
    }
}
