package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements x.a {
    final /* synthetic */ e bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bGV = eVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bGV.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
