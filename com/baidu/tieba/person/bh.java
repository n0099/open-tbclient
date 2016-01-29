package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity cZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.cZc = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cZc.finish();
    }
}
