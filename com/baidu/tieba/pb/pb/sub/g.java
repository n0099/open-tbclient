package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        ak akVar;
        ak akVar2;
        tVar = this.cgV.cgO;
        akVar = this.cgV.cgM;
        String afM = akVar.afM();
        akVar2 = this.cgV.cgM;
        tVar.aX(afM, akVar2.afP());
    }
}
