package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements ab.b {
    final /* synthetic */ f dhP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dhP = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        if (!z) {
            this.dhP.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
