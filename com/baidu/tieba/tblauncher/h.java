package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.fQz = true;
    }
}
