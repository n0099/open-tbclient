package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity dnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.dnY = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dnY.mr(com.baidu.adp.lib.util.j.a(this.dnY.bHL.getText(), ""));
    }
}
