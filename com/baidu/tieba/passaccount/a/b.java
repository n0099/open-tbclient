package com.baidu.tieba.passaccount.a;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.passaccount.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0033a {
    final /* synthetic */ a dcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dcj = aVar;
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void ce(String str) {
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        interfaceC0066a = this.dcj.dcg;
        if (interfaceC0066a != null) {
            interfaceC0066a2 = this.dcj.dcg;
            interfaceC0066a2.ce(str);
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void a(AccountData accountData) {
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        interfaceC0066a = this.dcj.dcg;
        if (interfaceC0066a != null) {
            interfaceC0066a2 = this.dcj.dcg;
            interfaceC0066a2.onSuccess();
        }
    }

    @Override // com.baidu.tbadk.core.a.a.InterfaceC0033a
    public void b(String str, int i, String str2) {
        if (i == 1) {
            ReloginManager.sM().e(null);
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Void[0]);
    }
}
