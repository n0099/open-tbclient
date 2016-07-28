package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fTK = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fTK.rI(com.baidu.adp.lib.util.j.a(this.fTK.cZK.getText(), ""));
    }
}
