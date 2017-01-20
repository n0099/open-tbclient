package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0032a {
    final /* synthetic */ a ecA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ecA = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void cf(String str) {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        interfaceC0067a = this.ecA.ecx;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.ecA.ecx;
            interfaceC0067a2.cf(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void a(AccountData accountData) {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        interfaceC0067a = this.ecA.ecx;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.ecA.ecx;
            interfaceC0067a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0032a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tL().f(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
