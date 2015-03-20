package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai aiVar;
        ai aiVar2;
        aiVar = this.this$0.cqV;
        if (aiVar.isMenuShowing()) {
            aiVar2 = this.this$0.cqV;
            aiVar2.aoj();
        }
    }
}
