package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.h();
    }
}
