package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ AccountData eoj;
    final /* synthetic */ o eon;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, AccountData accountData) {
        this.eon = oVar;
        this.eoj = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.eoj);
    }
}
