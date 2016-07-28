package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ l dUP;
    private final /* synthetic */ AccountData dUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, AccountData accountData) {
        this.dUP = lVar;
        this.dUQ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.dUQ);
    }
}
