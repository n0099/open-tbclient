package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements Runnable {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.a.j;
        if (z) {
            this.a.c();
        }
    }
}
