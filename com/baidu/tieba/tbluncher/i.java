package com.baidu.tieba.tbluncher;
/* loaded from: classes.dex */
final class i implements Runnable {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();
    }
}
