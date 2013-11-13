package com.baidu.tieba.square;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SquareActivity squareActivity) {
        this.f2384a = squareActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bw bwVar;
        try {
            bwVar = this.f2384a.b;
            bwVar.a();
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
