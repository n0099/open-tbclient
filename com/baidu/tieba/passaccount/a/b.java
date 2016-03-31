package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0042a {
    final /* synthetic */ a cZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cZO = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void cg(String str) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        interfaceC0073a = this.cZO.cZL;
        if (interfaceC0073a != null) {
            interfaceC0073a2 = this.cZO.cZL;
            interfaceC0073a2.cg(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void a(AccountData accountData) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        interfaceC0073a = this.cZO.cZL;
        if (interfaceC0073a != null) {
            interfaceC0073a2 = this.cZO.cZL;
            interfaceC0073a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0042a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.vf().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
