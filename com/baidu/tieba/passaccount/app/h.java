package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ f eoi;
    private final /* synthetic */ AccountData eoj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, AccountData accountData) {
        this.eoi = fVar;
        this.eoj = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.eoj);
    }
}
