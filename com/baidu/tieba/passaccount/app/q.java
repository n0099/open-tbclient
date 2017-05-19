package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ AccountData dZS;
    final /* synthetic */ o dZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, AccountData accountData) {
        this.dZW = oVar;
        this.dZS = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.dZS);
    }
}
