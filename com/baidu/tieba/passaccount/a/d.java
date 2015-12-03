package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a cww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cww = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0077a interfaceC0077a;
        a.InterfaceC0077a interfaceC0077a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0077a = this.cww.cwt;
        if (interfaceC0077a != null) {
            interfaceC0077a2 = this.cww.cwt;
            interfaceC0077a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void ko(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cj(str);
        }
    }
}
