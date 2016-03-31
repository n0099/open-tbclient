package com.baidu.tieba.pb.pb.b;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnFocusChangeListener {
    final /* synthetic */ b dfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.dfC = bVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && view != null) {
            view.clearFocus();
        }
    }
}
