package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bWd.bVb.requestFocus();
        com.baidu.adp.lib.util.k.d(this.bWd.getPageContext().getPageActivity(), this.bWd.bVb);
    }
}
