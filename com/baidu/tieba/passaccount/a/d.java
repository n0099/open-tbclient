package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a cAa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cAa = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0071a interfaceC0071a;
        a.InterfaceC0071a interfaceC0071a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0071a = this.cAa.czX;
        if (interfaceC0071a != null) {
            interfaceC0071a2 = this.cAa.czX;
            interfaceC0071a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void kk(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cl(str);
        }
    }
}
