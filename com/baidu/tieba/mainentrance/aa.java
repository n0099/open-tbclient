package com.baidu.tieba.mainentrance;

import com.baidu.tieba.view.bp;
/* loaded from: classes.dex */
final class aa implements bp {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.bp
    public final void a(boolean z) {
        com.baidu.adp.lib.util.e.e("simon", "onSoftKeyboardShown", String.valueOf(z));
        this.a.G = z;
    }
}
