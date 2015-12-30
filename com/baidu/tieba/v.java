package com.baidu.tieba;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ u aHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aHF = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aHF.this$0;
        if (updateDialog.aHB.forceUpdate()) {
            updateDialog2 = this.aHF.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
