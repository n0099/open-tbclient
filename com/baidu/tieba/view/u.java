package com.baidu.tieba.view;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s gaH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.gaH = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gaH.eUV.smoothScrollToPosition(4);
    }
}
