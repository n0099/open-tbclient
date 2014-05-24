package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f();
    }
}
