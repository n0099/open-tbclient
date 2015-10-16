package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        ak akVar;
        ak akVar2;
        tVar = this.cmC.cmv;
        akVar = this.cmC.cmt;
        String ahJ = akVar.ahJ();
        akVar2 = this.cmC.cmt;
        tVar.aY(ahJ, akVar2.ahN());
    }
}
