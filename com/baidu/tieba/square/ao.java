package com.baidu.tieba.square;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ SquareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SquareActivity squareActivity) {
        this.a = squareActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        try {
            bzVar = this.a.b;
            bzVar.a();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
