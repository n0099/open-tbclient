package com.baidu.tieba.selectpoi;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ NavigationBarActivity feQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NavigationBarActivity navigationBarActivity) {
        this.feQ = navigationBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.feQ.finish();
    }
}
