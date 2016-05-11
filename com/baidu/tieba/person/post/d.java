package com.baidu.tieba.person.post;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity dEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.dEo = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dEo.finish();
    }
}
