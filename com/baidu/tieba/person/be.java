package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonImageActivity personImageActivity) {
        this.bCW = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bCW.finish();
    }
}
