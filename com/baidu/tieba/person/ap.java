package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class ap implements View.OnClickListener {
    final /* synthetic */ MyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MyPostActivity myPostActivity) {
        this.a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
