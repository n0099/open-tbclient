package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity dch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.dch = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dch.lJ(com.baidu.adp.lib.util.j.a(this.dch.bEI.getText(), ""));
    }
}
