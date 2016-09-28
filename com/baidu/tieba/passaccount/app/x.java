package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class x implements Runnable {
    private final /* synthetic */ AccountData eiQ;
    final /* synthetic */ v eiU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, AccountData accountData) {
        this.eiU = vVar;
        this.eiQ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.eiQ);
    }
}
