package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ s bPU;
    private final /* synthetic */ String bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, String str) {
        this.bPU = sVar;
        this.bPV = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bPU.iw(this.bPV);
    }
}
