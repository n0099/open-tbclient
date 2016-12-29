package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a dTH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dTH = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0065a = this.dTH.dTE;
        if (interfaceC0065a != null) {
            interfaceC0065a2 = this.dTH.dTE;
            interfaceC0065a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.ci(str);
        }
    }
}
