package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class k implements q.a {
    final /* synthetic */ e bZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bZK = eVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bZK.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
