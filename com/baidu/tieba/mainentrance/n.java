package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cqu.cpr.requestFocus();
        com.baidu.adp.lib.util.k.d(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
    }
}
