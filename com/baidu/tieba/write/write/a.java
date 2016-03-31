package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity eLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.eLC = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eLC.oY(com.baidu.adp.lib.util.j.a(this.eLC.cqC.getText(), ""));
    }
}
