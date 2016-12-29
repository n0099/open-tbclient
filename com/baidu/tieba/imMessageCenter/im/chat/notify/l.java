package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class l implements z.b {
    final /* synthetic */ f cZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.cZJ = fVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aM(boolean z) {
        if (!z) {
            this.cZJ.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
