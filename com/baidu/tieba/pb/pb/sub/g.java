package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        ak akVar;
        ak akVar2;
        tVar = this.cmr.cmk;
        akVar = this.cmr.cmi;
        String ahJ = akVar.ahJ();
        akVar2 = this.cmr.cmi;
        tVar.aY(ahJ, akVar2.ahN());
    }
}
