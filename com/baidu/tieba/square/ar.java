package com.baidu.tieba.square;
/* loaded from: classes.dex */
final class ar implements Runnable {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(am amVar) {
        this.a = amVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ba baVar;
        try {
            baVar = this.a.c;
            baVar.a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
