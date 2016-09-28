package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0033a {
    final /* synthetic */ a ejc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ejc = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void cf(String str) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        interfaceC0072a = this.ejc.eiZ;
        if (interfaceC0072a != null) {
            interfaceC0072a2 = this.ejc.eiZ;
            interfaceC0072a2.cf(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        interfaceC0072a = this.ejc.eiZ;
        if (interfaceC0072a != null) {
            interfaceC0072a2 = this.ejc.eiZ;
            interfaceC0072a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.uc().f(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
