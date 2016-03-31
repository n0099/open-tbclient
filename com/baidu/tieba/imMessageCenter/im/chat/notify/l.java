package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements s.a {
    final /* synthetic */ f csQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.csQ = fVar;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        if (!z) {
            this.csQ.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
