package com.baidu.tieba.selectpoi;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ NavigationBarActivity fnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NavigationBarActivity navigationBarActivity) {
        this.fnp = navigationBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fnp.finish();
    }
}
