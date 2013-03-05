package com.baidu.tieba.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.account.LoginActivity;
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
        nVar = this.a.d;
        if (nVar.getItemId(i) >= 0) {
            nVar2 = this.a.d;
            if (!nVar2.a()) {
                nVar3 = this.a.d;
                com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) nVar3.getItem(i);
                if (aVar != null && aVar.e() != 1) {
                    this.a.k = new l(this.a, aVar);
                    lVar = this.a.k;
                    lVar.execute(new Object[0]);
                    return;
                }
                return;
            }
            return;
        }
        LoginActivity.a(this.a);
    }
}
