package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity gdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.gdO = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gdO.ss(com.baidu.adp.lib.util.j.a(this.gdO.dlt.getText(), ""));
    }
}
