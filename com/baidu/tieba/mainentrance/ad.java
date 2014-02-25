package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.bp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements bp {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.bp
    public void a(boolean z) {
        com.baidu.adp.lib.util.f.e("simon", "onSoftKeyboardShown", String.valueOf(z));
        this.a.G = z;
    }
}
