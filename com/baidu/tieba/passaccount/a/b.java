package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0041a {
    final /* synthetic */ a cww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cww = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ci(String str) {
        a.InterfaceC0077a interfaceC0077a;
        a.InterfaceC0077a interfaceC0077a2;
        interfaceC0077a = this.cww.cwt;
        if (interfaceC0077a != null) {
            interfaceC0077a2 = this.cww.cwt;
            interfaceC0077a2.ci(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        a.InterfaceC0077a interfaceC0077a;
        a.InterfaceC0077a interfaceC0077a2;
        interfaceC0077a = this.cww.cwt;
        if (interfaceC0077a != null) {
            interfaceC0077a2 = this.cww.cwt;
            interfaceC0077a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tU().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
