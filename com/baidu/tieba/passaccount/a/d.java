package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a cdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cdx = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0069a interfaceC0069a;
        a.InterfaceC0069a interfaceC0069a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0069a = this.cdx.cdu;
        if (interfaceC0069a != null) {
            interfaceC0069a2 = this.cdx.cdu;
            interfaceC0069a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void jx(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.ce(str);
        }
    }
}
