package com.baidu.tieba.square;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tieba.view.bi {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tieba.view.bi
    public void a(boolean z) {
        com.baidu.adp.lib.g.e.e("simon", "onSoftKeyboardShown", String.valueOf(z));
        this.a.G = z;
    }
}
