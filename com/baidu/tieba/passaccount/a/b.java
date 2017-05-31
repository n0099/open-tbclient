package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0035a {
    final /* synthetic */ a efy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.efy = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void cf(String str) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void a(AccountData accountData) {
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0035a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tR().f(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
