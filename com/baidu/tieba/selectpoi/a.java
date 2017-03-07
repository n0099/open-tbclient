package com.baidu.tieba.selectpoi;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ NavigationBarActivity ffb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NavigationBarActivity navigationBarActivity) {
        this.ffb = navigationBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ffb.finish();
    }
}
