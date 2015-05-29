package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        ak akVar;
        ak akVar2;
        sVar = this.bPw.bPq;
        akVar = this.bPw.bPn;
        String adI = akVar.adI();
        akVar2 = this.bPw.bPn;
        sVar.aV(adI, akVar2.adL());
    }
}
