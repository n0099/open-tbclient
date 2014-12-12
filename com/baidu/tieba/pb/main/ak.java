package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bzj.byO;
        if (!bzVar.Yj()) {
            bzVar3 = this.bzj.byO;
            bzVar3.dR(false);
            return;
        }
        bzVar2 = this.bzj.byO;
        bzVar2.dR(true);
    }
}
