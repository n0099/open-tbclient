package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes2.dex */
class l implements ae.b {
    final /* synthetic */ f drz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.drz = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.drz.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
