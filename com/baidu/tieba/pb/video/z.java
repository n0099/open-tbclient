package com.baidu.tieba.pb.video;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ y eAY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.eAY = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        lVar = this.eAY.eAW;
        lVar.eAP = true;
    }
}
