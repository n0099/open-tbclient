package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ag agVar;
        ax axVar;
        ax axVar2;
        agVar = this.exF.exu;
        axVar = this.exF.exr;
        String aRA = axVar.aRA();
        axVar2 = this.exF.exr;
        agVar.bH(aRA, axVar2.aRE());
    }
}
