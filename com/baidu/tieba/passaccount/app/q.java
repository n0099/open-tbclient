package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class q implements Runnable {
    private final /* synthetic */ AccountData efj;
    final /* synthetic */ o efn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, AccountData accountData) {
        this.efn = oVar;
        this.efj = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.efj);
    }
}
