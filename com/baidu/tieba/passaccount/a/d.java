package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a ejc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.ejc = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0072a interfaceC0072a;
        a.InterfaceC0072a interfaceC0072a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0072a = this.ejc.eiZ;
        if (interfaceC0072a != null) {
            interfaceC0072a2 = this.ejc.eiZ;
            interfaceC0072a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cg(str);
        }
    }
}
