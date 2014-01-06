package com.baidu.tieba.write;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.finish();
    }
}
