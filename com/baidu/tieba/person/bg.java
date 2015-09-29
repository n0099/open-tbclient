package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity cqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.cqo = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cqo.finish();
    }
}
