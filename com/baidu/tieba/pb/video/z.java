package com.baidu.tieba.pb.video;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ y eKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.eKw = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        lVar = this.eKw.eKu;
        lVar.eKn = true;
    }
}
