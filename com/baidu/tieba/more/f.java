package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1490a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.f1490a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        AccountData accountData = (AccountData) view.getTag();
        if (accountData != null) {
            this.f1490a.j = new i(this.f1490a, accountData);
            iVar = this.f1490a.j;
            iVar.setPriority(3);
            iVar2 = this.f1490a.j;
            iVar2.execute(new Object[0]);
        }
    }
}
