package com.baidu.tieba.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        m mVar3;
        k kVar;
        mVar = this.a.c;
        if (mVar.getItemId(i) < 0) {
            LoginActivity.a(this.a);
            return;
        }
        mVar2 = this.a.c;
        if (mVar2.a()) {
            return;
        }
        mVar3 = this.a.c;
        com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) mVar3.getItem(i);
        if (aVar == null || aVar.e() == 1) {
            return;
        }
        this.a.h = new k(this.a, aVar);
        kVar = this.a.h;
        kVar.execute(new Object[0]);
    }
}
