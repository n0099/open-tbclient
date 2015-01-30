package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PersonImageActivity personImageActivity) {
        this.bIh = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bIh.finish();
    }
}
