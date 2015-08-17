package com.baidu.tieba;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aDq = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aDq.this$0;
        if (updateDialog.aDm.forceUpdate()) {
            updateDialog2 = this.aDq.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
