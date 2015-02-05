package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai aiVar;
        ai aiVar2;
        aiVar = this.this$0.ccJ;
        if (aiVar.isMenuShowing()) {
            aiVar2 = this.this$0.ccJ;
            aiVar2.ajq();
        }
    }
}
