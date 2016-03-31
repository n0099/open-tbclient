package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ k cZF;
    private final /* synthetic */ AccountData cZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, AccountData accountData) {
        this.cZF = kVar;
        this.cZG = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.cZG);
    }
}
