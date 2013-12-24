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
        bu buVar;
        try {
            buVar = this.a.b;
            buVar.a();
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
