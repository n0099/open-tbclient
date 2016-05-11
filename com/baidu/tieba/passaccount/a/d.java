package com.baidu.tieba.passaccount.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.a;
import com.baidu.tieba.passaccount.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f.a {
    final /* synthetic */ a dcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dcj = aVar;
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void a(AccountData accountData) {
        a.InterfaceC0066a interfaceC0066a;
        a.InterfaceC0066a interfaceC0066a2;
        new e(this, accountData).execute(new Void[0]);
        interfaceC0066a = this.dcj.dcg;
        if (interfaceC0066a != null) {
            interfaceC0066a2 = this.dcj.dcg;
            interfaceC0066a2.onSuccess();
        }
    }

    @Override // com.baidu.tieba.passaccount.a.f.a
    public void onFailure(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.a.b.cf(str);
        }
    }
}
