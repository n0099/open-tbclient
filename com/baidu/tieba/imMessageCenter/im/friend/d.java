package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ IMBlackListActivity ckT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IMBlackListActivity iMBlackListActivity) {
        this.ckT = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
