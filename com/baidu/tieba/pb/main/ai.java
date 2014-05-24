package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bqVar = this.a.D;
        if (!bqVar.D()) {
            bqVar3 = this.a.D;
            bqVar3.b(false);
            return;
        }
        bqVar2 = this.a.D;
        bqVar2.b(true);
    }
}
