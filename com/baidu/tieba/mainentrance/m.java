package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cMQ.cLO.requestFocus();
        com.baidu.adp.lib.util.k.b(this.cMQ.getPageContext().getPageActivity(), this.cMQ.cLO);
    }
}
