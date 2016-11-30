package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity gnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.gnC = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gnC.td(com.baidu.adp.lib.util.j.a(this.gnC.dsz.getText(), ""));
    }
}
