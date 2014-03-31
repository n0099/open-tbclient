package com.baidu.tieba.signall;
/* loaded from: classes.dex */
final class w implements Runnable {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.postDelayed(this, 2000L);
    }
}
