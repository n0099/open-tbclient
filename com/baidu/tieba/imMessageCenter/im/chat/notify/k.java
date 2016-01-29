package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ e cil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.cil = eVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        if (!z) {
            this.cil.sendMessage(new RequestMemoryListMessage(1));
        }
    }
}
