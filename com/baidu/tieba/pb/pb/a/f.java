package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.dXu = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        s sVar2;
        s sVar3;
        sVar = this.dXu.dXm;
        if (sVar != null) {
            sVar2 = this.dXu.dXm;
            if (sVar2.aNV != null) {
                sVar3 = this.dXu.dXm;
                if (!sVar3.aNV.isPlaying()) {
                    this.dXu.e(true, 0);
                }
            }
        }
    }
}
