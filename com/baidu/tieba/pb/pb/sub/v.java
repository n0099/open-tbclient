package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s bPT;
    private final /* synthetic */ String bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, String str) {
        this.bPT = sVar;
        this.bPU = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bPT.iw(this.bPU);
    }
}
