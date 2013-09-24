package com.baidu.tieba.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1492a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.f1492a = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar;
        o oVar2;
        o oVar3;
        l lVar;
        l lVar2;
        oVar = this.f1492a.b;
        if (oVar.getItemId(i) >= 0) {
            oVar2 = this.f1492a.b;
            if (!oVar2.a()) {
                oVar3 = this.f1492a.b;
                AccountData accountData = (AccountData) oVar3.getItem(i);
                if (accountData != null && accountData.getIsActive() != 1) {
                    this.f1492a.g = new l(this.f1492a, accountData);
                    lVar = this.f1492a.g;
                    lVar.setPriority(3);
                    lVar2 = this.f1492a.g;
                    lVar2.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.a(this.f1492a);
    }
}
