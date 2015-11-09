package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.dqn = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dqn.my(com.baidu.adp.lib.util.j.a(this.dqn.bIr.getText(), ""));
    }
}
