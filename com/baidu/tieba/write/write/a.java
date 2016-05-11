package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fcq.pm(com.baidu.adp.lib.util.j.a(this.fcq.crz.getText(), ""));
    }
}
