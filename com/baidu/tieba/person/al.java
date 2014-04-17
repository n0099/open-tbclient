package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al implements Runnable {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.a.j;
        if (z) {
            this.a.d();
        }
    }
}
