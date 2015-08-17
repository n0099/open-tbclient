package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cTk = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cTk.lc(com.baidu.adp.lib.util.j.a(this.cTk.bEb.getText(), ""));
    }
}
