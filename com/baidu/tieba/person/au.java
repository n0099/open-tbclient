package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PersonImageActivity personImageActivity) {
        this.bQo = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQo.finish();
    }
}
