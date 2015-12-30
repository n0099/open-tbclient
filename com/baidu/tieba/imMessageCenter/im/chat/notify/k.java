package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ e cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.cdL = eVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.cdL.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
