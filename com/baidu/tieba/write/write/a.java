package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.dWP = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dWP.nr(com.baidu.adp.lib.util.j.a(this.dWP.cbx.getText(), ""));
    }
}
