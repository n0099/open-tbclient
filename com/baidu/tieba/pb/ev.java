package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class ev implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.closeActivity();
    }
}
