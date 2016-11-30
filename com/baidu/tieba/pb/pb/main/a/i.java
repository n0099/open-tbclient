package com.baidu.tieba.pb.pb.main.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f eDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eDr = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.eDr.Hu;
        if (dVar != null) {
            dVar2 = this.eDr.Hu;
            dVar2.dismiss();
        }
    }
}
