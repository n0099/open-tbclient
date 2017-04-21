package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fSZ = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fSZ.rl(com.baidu.adp.lib.util.j.a(this.fSZ.dhM.getText(), ""));
    }
}
