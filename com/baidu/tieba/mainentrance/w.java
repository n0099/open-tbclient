package com.baidu.tieba.mainentrance;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ v btc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.btc = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.j.aim();
    }
}
