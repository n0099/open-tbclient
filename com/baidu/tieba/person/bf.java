package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bf implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity ckK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonImageActivity personImageActivity) {
        this.ckK = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ckK.finish();
    }
}
