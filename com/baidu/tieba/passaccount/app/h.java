package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f efn;
    private final /* synthetic */ AccountData efo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, AccountData accountData) {
        this.efn = fVar;
        this.efo = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.efo);
    }
}
