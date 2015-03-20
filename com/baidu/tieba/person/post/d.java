package com.baidu.tieba.person.post;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.bRh = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bRh.finish();
    }
}
