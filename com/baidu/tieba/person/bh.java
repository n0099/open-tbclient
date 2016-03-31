package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bh implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity dtF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.dtF = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dtF.finish();
    }
}
