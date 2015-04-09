package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ l bOv;
    private final /* synthetic */ String bOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, String str) {
        this.bOv = lVar;
        this.bOw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOv.hS(this.bOw);
    }
}
