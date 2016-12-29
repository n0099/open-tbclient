package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity fCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.fCf = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fCf.rq(com.baidu.adp.lib.util.j.a(this.fCf.cXt.getText(), ""));
    }
}
