package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a cZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cZO = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0073a interfaceC0073a;
        a.InterfaceC0073a interfaceC0073a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0073a = this.cZO.cZL;
        if (interfaceC0073a != null) {
            interfaceC0073a2 = this.cZO.cZL;
            interfaceC0073a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.ch(str);
        }
    }
}
