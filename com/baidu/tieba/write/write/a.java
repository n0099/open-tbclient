package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fOT = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fOT.qR(com.baidu.adp.lib.util.j.a(this.fOT.dgY.getText(), ""));
    }
}
