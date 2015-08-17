package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQZ.bQb.requestFocus();
        com.baidu.adp.lib.util.k.d(this.bQZ.getPageContext().getPageActivity(), this.bQZ.bQb);
    }
}
