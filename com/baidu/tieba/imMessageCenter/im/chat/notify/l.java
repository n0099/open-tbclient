package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements aa.b {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dgY = fVar;
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
        if (!z) {
            this.dgY.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
