package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fcp = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fcp.pm(com.baidu.adp.lib.util.j.a(this.fcp.crz.getText(), ""));
    }
}
