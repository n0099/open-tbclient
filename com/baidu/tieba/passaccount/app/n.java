package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ l dIG;
    private final /* synthetic */ AccountData dIH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, AccountData accountData) {
        this.dIG = lVar;
        this.dIH = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.dIH);
    }
}
