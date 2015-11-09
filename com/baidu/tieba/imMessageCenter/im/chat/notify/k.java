package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements p.a {
    final /* synthetic */ e bKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bKG = eVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bKG.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
