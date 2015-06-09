package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.aj;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements aj {
    final /* synthetic */ d bsx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.bsx = dVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bsx.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
