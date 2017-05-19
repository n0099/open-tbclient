package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f dZR;
    private final /* synthetic */ AccountData dZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, AccountData accountData) {
        this.dZR = fVar;
        this.dZS = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.dZS);
    }
}
