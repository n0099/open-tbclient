package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ae {
    final /* synthetic */ d bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.bpB = dVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bpB.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
