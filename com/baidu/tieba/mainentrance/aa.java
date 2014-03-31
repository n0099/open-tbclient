package com.baidu.tieba.mainentrance;

import android.view.View;
/* loaded from: classes.dex */
final class aa implements View.OnFocusChangeListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.i.a(this.a, view);
        }
    }
}
