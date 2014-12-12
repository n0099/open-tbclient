package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ax implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PersonImageActivity personImageActivity) {
        this.bGv = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGv.finish();
    }
}
