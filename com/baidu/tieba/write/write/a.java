package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity dPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.dPq = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dPq.nt(com.baidu.adp.lib.util.j.a(this.dPq.bXx.getText(), ""));
    }
}
