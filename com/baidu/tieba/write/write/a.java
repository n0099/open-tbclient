package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fRd = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fRd.rh(com.baidu.adp.lib.util.j.a(this.fRd.dbN.getText(), ""));
    }
}
