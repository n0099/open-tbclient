package com.baidu.tieba.person.post;

import android.view.View;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ PersonPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonPostActivity personPostActivity) {
        this.a = personPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
