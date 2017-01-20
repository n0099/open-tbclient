package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fKA = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fKA.rJ(com.baidu.adp.lib.util.j.a(this.fKA.deH.getText(), ""));
    }
}
