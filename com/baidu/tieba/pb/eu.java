package com.baidu.tieba.pb;

import android.view.View;
/* loaded from: classes.dex */
final class eu implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a.reload();
    }
}
