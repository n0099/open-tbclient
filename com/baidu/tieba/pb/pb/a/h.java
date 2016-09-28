package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.emY = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        v vVar;
        v vVar2;
        v vVar3;
        vVar = this.emY.emT;
        if (vVar != null) {
            vVar2 = this.emY.emT;
            if (vVar2.aMF != null) {
                vVar3 = this.emY.emT;
                if (!vVar3.aMF.isPlaying()) {
                    this.emY.e(true, 0);
                }
            }
        }
    }
}
