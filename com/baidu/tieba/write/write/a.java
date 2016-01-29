package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity erI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.erI = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.erI.nJ(com.baidu.adp.lib.util.j.a(this.erI.cfX.getText(), ""));
    }
}
