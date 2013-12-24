package com.baidu.tieba.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        p pVar2;
        p pVar3;
        m mVar;
        m mVar2;
        pVar = this.a.b;
        if (pVar.getItemId(i) >= 0) {
            pVar2 = this.a.b;
            if (!pVar2.a()) {
                pVar3 = this.a.b;
                AccountData accountData = (AccountData) pVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    this.a.g = new m(this.a, accountData);
                    mVar = this.a.g;
                    mVar.setPriority(3);
                    mVar2 = this.a.g;
                    mVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.a(this.a);
    }
}
