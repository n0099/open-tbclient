package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.crV = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.crV.finish();
    }
}
