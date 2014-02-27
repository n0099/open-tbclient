package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class ch implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
