package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cmr.cln.requestFocus();
        com.baidu.adp.lib.util.k.d(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
    }
}
