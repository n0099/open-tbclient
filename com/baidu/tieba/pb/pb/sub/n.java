package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ag agVar;
        ax axVar;
        ax axVar2;
        agVar = this.evy.evn;
        axVar = this.evy.evl;
        String aQS = axVar.aQS();
        axVar2 = this.evy.evl;
        agVar.bF(aQS, axVar2.aQW());
    }
}
