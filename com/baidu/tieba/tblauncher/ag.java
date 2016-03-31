package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ag implements Runnable {
    private final /* synthetic */ AccountData Rl;
    final /* synthetic */ aa etY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(aa aaVar, AccountData accountData) {
        this.etY = aaVar;
        this.Rl = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Rl);
    }
}
