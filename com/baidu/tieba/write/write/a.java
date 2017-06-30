package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gjY.sv(com.baidu.adp.lib.util.j.a(this.gjY.dpg.getText(), ""));
    }
}
