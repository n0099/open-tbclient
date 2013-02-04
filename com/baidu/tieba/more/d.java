package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) view.getTag();
        if (aVar != null) {
            this.a.i = new h(this.a, aVar);
            hVar = this.a.i;
            hVar.execute(new Object[0]);
        }
    }
}
