package com.baidu.tieba.person.post;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity ckK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonPostActivity personPostActivity) {
        this.ckK = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ckK.finish();
    }
}
