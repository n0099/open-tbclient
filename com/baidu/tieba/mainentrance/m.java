package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cwZ.cvX.requestFocus();
        com.baidu.adp.lib.util.k.d(this.cwZ.getPageContext().getPageActivity(), this.cwZ.cvX);
    }
}
