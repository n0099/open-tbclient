package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnLongClickListener {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }
}
