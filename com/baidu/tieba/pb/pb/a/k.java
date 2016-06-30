package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.dML = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        y yVar3;
        yVar = this.dML.dMD;
        if (yVar != null) {
            yVar2 = this.dML.dMD;
            if (yVar2.aJJ != null) {
                yVar3 = this.dML.dMD;
                if (!yVar3.aJJ.isPlaying()) {
                    this.dML.d(true, 0);
                }
            }
        }
    }
}
