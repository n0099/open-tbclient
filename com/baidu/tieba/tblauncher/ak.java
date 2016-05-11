package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ak implements Runnable {
    private final /* synthetic */ AccountData Mb;
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ab abVar, AccountData accountData) {
        this.exg = abVar;
        this.Mb = accountData;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.a.b.b(this.Mb);
    }
}
