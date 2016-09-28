package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity gfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.gfY = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gfY.sH(com.baidu.adp.lib.util.j.a(this.gfY.dmQ.getText(), ""));
    }
}
