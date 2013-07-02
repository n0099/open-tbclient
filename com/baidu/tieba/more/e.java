package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        AccountData accountData = (AccountData) view.getTag();
        if (accountData != null) {
            this.a.l = new i(this.a, accountData);
            iVar = this.a.l;
            iVar.setPriority(3);
            iVar2 = this.a.l;
            iVar2.execute(new Object[0]);
        }
    }
}
