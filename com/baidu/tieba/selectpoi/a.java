package com.baidu.tieba.selectpoi;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ NavigationBarActivity drR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NavigationBarActivity navigationBarActivity) {
        this.drR = navigationBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.drR.finish();
    }
}
