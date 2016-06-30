package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fHT = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fHT.qY(com.baidu.adp.lib.util.j.a(this.fHT.cWP.getText(), ""));
    }
}
