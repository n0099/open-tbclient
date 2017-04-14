package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fQD = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQD.rk(com.baidu.adp.lib.util.j.a(this.fQD.dfv.getText(), ""));
    }
}
