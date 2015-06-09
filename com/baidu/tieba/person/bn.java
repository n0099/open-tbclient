package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonImageActivity personImageActivity) {
        this.bTk = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTk.finish();
    }
}
