package com.baidu.tieba.tblauncher;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        an anVar;
        an anVar2;
        anVar = this.this$0.caU;
        if (anVar.isMenuShowing()) {
            anVar2 = this.this$0.caU;
            anVar2.aiT();
        }
    }
}
