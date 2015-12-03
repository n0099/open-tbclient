package com.baidu.tieba.tbean;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BuyTBeanActivity dCl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BuyTBeanActivity buyTBeanActivity) {
        this.dCl = buyTBeanActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dCl.finish();
    }
}
