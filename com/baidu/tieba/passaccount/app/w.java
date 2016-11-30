package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class w implements Runnable {
    private final /* synthetic */ AccountData eoO;
    final /* synthetic */ u eoS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, AccountData accountData) {
        this.eoS = uVar;
        this.eoO = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.eoO);
    }
}
