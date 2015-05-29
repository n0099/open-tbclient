package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonImageActivity personImageActivity) {
        this.bTj = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTj.finish();
    }
}
