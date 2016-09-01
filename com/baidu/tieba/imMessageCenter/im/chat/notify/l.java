package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements t.b {
    final /* synthetic */ f dnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dnI = fVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        if (!z) {
            this.dnI.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
