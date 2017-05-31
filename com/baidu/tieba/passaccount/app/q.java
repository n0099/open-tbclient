package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ AccountData efo;
    final /* synthetic */ o efs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, AccountData accountData) {
        this.efs = oVar;
        this.efo = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.efo);
    }
}
