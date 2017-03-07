package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.eeV = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0066a = this.eeV.eeS;
        if (interfaceC0066a != null) {
            interfaceC0066a2 = this.eeV.eeS;
            interfaceC0066a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.bZ(str);
        }
    }
}
