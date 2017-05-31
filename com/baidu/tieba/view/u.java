package com.baidu.tieba.view;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s fQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.fQQ = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQQ.eKW.smoothScrollToPosition(4);
    }
}
