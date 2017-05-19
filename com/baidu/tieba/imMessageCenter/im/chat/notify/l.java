package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes2.dex */
class l implements ae.b {
    final /* synthetic */ f dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dei = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
        if (!z) {
            this.dei.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
