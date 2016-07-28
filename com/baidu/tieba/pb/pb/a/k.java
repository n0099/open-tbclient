package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.dYX = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.dYX.dYN;
        if (yVar != null) {
            yVar2 = this.dYX.dYN;
            if (yVar2.aKC != null) {
                yVar3 = this.dYX.dYN;
                if (!yVar3.aKC.isPlaying()) {
                    this.dYX.e(true, 0);
                }
            }
        }
    }
}
