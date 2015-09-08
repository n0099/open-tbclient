package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ SquareSearchActivity bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SquareSearchActivity squareSearchActivity) {
        this.bRF = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bRF.bQH.requestFocus();
        com.baidu.adp.lib.util.k.d(this.bRF.getPageContext().getPageActivity(), this.bRF.bQH);
    }
}
