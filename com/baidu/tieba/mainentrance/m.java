package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnFocusChangeListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.m.b(this.bnc, view);
        }
    }
}
