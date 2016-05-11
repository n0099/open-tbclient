package com.baidu.tieba.pb.pb.b;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnFocusChangeListener {
    final /* synthetic */ l die;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.die = lVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && view != null) {
            view.clearFocus();
        }
    }
}
