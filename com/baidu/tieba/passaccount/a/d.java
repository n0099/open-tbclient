package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a dIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dIP = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0070a interfaceC0070a;
        a.InterfaceC0070a interfaceC0070a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0070a = this.dIP.dIM;
        if (interfaceC0070a != null) {
            interfaceC0070a2 = this.dIP.dIM;
            interfaceC0070a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.ce(str);
        }
    }
}
