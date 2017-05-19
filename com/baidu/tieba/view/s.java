package com.baidu.tieba.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ q fIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.fIZ = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fIZ.fIL.smoothScrollToPosition(4);
    }
}
