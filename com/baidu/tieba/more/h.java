package com.baidu.tieba.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n nVar;
        n nVar2;
        n nVar3;
        l lVar;
        l lVar2;
        nVar = this.a.b;
        if (nVar.getItemId(i) >= 0) {
            nVar2 = this.a.b;
            if (!nVar2.a()) {
                nVar3 = this.a.b;
                AccountData accountData = (AccountData) nVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    this.a.k = new l(this.a, accountData);
                    lVar = this.a.k;
                    lVar.setPriority(3);
                    lVar2 = this.a.k;
                    lVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.a(this.a);
    }
}
