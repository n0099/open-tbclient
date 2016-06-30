package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements t.b {
    final /* synthetic */ f cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.cZd = fVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        if (!z) {
            this.cZd.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
