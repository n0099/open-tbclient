package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements z.b {
    final /* synthetic */ f duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.duO = fVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        if (!z) {
            this.duO.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
