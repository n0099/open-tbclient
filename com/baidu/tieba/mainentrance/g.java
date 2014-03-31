package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
final class g implements com.baidu.tieba.view.v {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.v
    public final void a(boolean z) {
        com.baidu.adp.lib.util.f.e("simon", "onSoftKeyboardShown", String.valueOf(z));
        this.a.C = z;
    }
}
