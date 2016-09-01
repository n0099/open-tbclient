package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.elb = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.elb.ekR;
        if (yVar != null) {
            yVar2 = this.elb.ekR;
            if (yVar2.aPh != null) {
                yVar3 = this.elb.ekR;
                if (!yVar3.aPh.isPlaying()) {
                    this.elb.d(true, 0);
                }
            }
        }
    }
}
