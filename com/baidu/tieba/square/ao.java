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
        by byVar;
        try {
            byVar = this.a.b;
            byVar.a();
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
