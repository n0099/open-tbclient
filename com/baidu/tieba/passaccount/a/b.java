package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0040a {
    final /* synthetic */ a cdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cdx = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void cd(String str) {
        a.InterfaceC0069a interfaceC0069a;
        a.InterfaceC0069a interfaceC0069a2;
        interfaceC0069a = this.cdx.cdu;
        if (interfaceC0069a != null) {
            interfaceC0069a2 = this.cdx.cdu;
            interfaceC0069a2.cd(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void a(AccountData accountData) {
        a.InterfaceC0069a interfaceC0069a;
        a.InterfaceC0069a interfaceC0069a2;
        interfaceC0069a = this.cdx.cdu;
        if (interfaceC0069a != null) {
            interfaceC0069a2 = this.cdx.cdu;
            interfaceC0069a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
    public void c(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.tp().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
