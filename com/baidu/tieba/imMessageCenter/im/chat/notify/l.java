package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements ab.b {
    final /* synthetic */ f dkg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dkg = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        if (!z) {
            this.dkg.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
