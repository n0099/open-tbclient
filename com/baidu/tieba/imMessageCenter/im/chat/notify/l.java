package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes2.dex */
class l implements ae.b {
    final /* synthetic */ f djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.djD = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.djD.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
