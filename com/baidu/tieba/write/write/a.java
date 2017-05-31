package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fYZ = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fYZ.rv(com.baidu.adp.lib.util.j.a(this.fYZ.dhk.getText(), ""));
    }
}
