package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bVC.bUA.requestFocus();
        com.baidu.adp.lib.util.k.d(this.bVC.getPageContext().getPageActivity(), this.bVC.bUA);
    }
}
