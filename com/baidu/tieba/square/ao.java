package com.baidu.tieba.square;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareActivity f2368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SquareActivity squareActivity) {
        this.f2368a = squareActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bu buVar;
        try {
            buVar = this.f2368a.b;
            buVar.a();
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("SquareActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
