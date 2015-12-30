package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity cPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.cPF = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPF.finish();
    }
}
