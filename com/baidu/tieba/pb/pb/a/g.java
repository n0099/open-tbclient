package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.esY = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        t tVar2;
        t tVar3;
        tVar = this.esY.esQ;
        if (tVar != null) {
            tVar2 = this.esY.esQ;
            if (tVar2.aOE != null) {
                tVar3 = this.esY.esQ;
                if (!tVar3.aOE.isPlaying()) {
                    this.esY.e(true, 0);
                }
            }
        }
    }
}
