package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0042a {
    final /* synthetic */ a cGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cGG = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cj(String str) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        interfaceC0073a = this.cGG.cGD;
        if (interfaceC0073a != null) {
            interfaceC0073a2 = this.cGG.cGD;
            interfaceC0073a2.cj(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        interfaceC0073a = this.cGG.cGD;
        if (interfaceC0073a != null) {
            interfaceC0073a2 = this.cGG.cGD;
            interfaceC0073a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.uJ().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
