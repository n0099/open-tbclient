package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a ecA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.ecA = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0067a interfaceC0067a;
        a.InterfaceC0067a interfaceC0067a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0067a = this.ecA.ecx;
        if (interfaceC0067a != null) {
            interfaceC0067a2 = this.ecA.ecx;
            interfaceC0067a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cg(str);
        }
    }
}
