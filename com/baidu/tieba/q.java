package com.baidu.tieba;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aEd = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aEd.this$0;
        if (updateDialog.aDZ.forceUpdate()) {
            updateDialog2 = this.aEd.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
