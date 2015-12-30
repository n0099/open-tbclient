package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0041a {
    final /* synthetic */ a cAa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cAa = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void ck(String str) {
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        interfaceC0071a = this.cAa.czX;
        if (interfaceC0071a != null) {
            interfaceC0071a2 = this.cAa.czX;
            interfaceC0071a2.ck(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void a(AccountData accountData) {
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        interfaceC0071a = this.cAa.czX;
        if (interfaceC0071a != null) {
            interfaceC0071a2 = this.cAa.czX;
            interfaceC0071a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0041a
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tE().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
