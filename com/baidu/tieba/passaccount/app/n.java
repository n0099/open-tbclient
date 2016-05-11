package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ l dca;
    private final /* synthetic */ AccountData dcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, AccountData accountData) {
        this.dca = lVar;
        this.dcb = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.dcb);
    }
}
