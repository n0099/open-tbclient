package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ck implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.ar byZ;
    private final /* synthetic */ boolean bza;
    private final /* synthetic */ String bzb;
    private final /* synthetic */ String bzc;
    final /* synthetic */ cj bzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, com.baidu.tieba.data.ar arVar, boolean z, String str, String str2) {
        this.bzd = cjVar;
        this.byZ = arVar;
        this.bza = z;
        this.bzb = str;
        this.bzc = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        cw cwVar;
        bv bvVar2;
        bv bvVar3;
        com.baidu.tieba.pb.sub.l lVar;
        bv bvVar4;
        cw cwVar2;
        bvVar = this.bzd.byW;
        cwVar = bvVar.byw;
        if (cwVar != null) {
            bvVar4 = this.bzd.byW;
            cwVar2 = bvVar4.byw;
            cwVar2.a(this.byZ);
        }
        if (this.bza) {
            bvVar3 = this.bzd.byW;
            lVar = bvVar3.bxU;
            lVar.aB(this.bzb, this.bzc);
        }
        bvVar2 = this.bzd.byW;
        bvVar2.Yj();
    }
}
