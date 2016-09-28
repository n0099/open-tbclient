package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements y.b {
    final /* synthetic */ f dpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dpg = fVar;
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        if (!z) {
            this.dpg.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
