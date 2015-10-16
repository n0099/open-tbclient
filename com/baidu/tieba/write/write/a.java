package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity doy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.doy = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.doy.mu(com.baidu.adp.lib.util.j.a(this.doy.bHW.getText(), ""));
    }
}
