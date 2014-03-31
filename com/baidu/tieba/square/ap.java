package com.baidu.tieba.square;
/* loaded from: classes.dex */
final class ap implements Runnable {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar) {
        this.a = akVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ay ayVar;
        try {
            ayVar = this.a.b;
            ayVar.a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
