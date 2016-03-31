package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cLU.cKS.requestFocus();
        com.baidu.adp.lib.util.k.d(this.cLU.getPageContext().getPageActivity(), this.cLU.cKS);
    }
}
