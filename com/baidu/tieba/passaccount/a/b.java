package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0033a {
    final /* synthetic */ a dTH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dTH = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ch(String str) {
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        interfaceC0065a = this.dTH.dTE;
        if (interfaceC0065a != null) {
            interfaceC0065a2 = this.dTH.dTE;
            interfaceC0065a2.ch(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        interfaceC0065a = this.dTH.dTE;
        if (interfaceC0065a != null) {
            interfaceC0065a2 = this.dTH.dTE;
            interfaceC0065a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tR().f(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
