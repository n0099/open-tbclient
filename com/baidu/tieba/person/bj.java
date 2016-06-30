package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity efn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.efn = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.efn.finish();
    }
}
