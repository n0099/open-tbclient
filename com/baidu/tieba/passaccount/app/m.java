package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k cdo;
    private final /* synthetic */ AccountData cdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, AccountData accountData) {
        this.cdo = kVar;
        this.cdp = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.cdp);
    }
}
