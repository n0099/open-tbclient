package com.baidu.tieba;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ u aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aGf = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aGf.this$0;
        if (updateDialog.aGb.forceUpdate()) {
            updateDialog2 = this.aGf.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
