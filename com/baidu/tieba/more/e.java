package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.f1411a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        AccountData accountData = (AccountData) view.getTag();
        if (accountData != null) {
            this.f1411a.l = new i(this.f1411a, accountData);
            iVar = this.f1411a.l;
            iVar.setPriority(3);
            iVar2 = this.f1411a.l;
            iVar2.execute(new Object[0]);
        }
    }
}
