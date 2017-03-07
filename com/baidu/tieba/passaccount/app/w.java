package com.baidu.tieba.passaccount.app;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class w implements Runnable {
    private final /* synthetic */ AccountData eeJ;
    final /* synthetic */ u eeN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, AccountData accountData) {
        this.eeN = uVar;
        this.eeJ = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.eeJ);
    }
}
