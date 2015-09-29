package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bVr.bUp.requestFocus();
        com.baidu.adp.lib.util.k.d(this.bVr.getPageContext().getPageActivity(), this.bVr.bUp);
    }
}
