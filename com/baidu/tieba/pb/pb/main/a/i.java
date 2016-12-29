package com.baidu.tieba.pb.pb.main.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ f eht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eht = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.eht.Ht;
        if (dVar != null) {
            dVar2 = this.eht.Ht;
            dVar2.dismiss();
        }
    }
}
