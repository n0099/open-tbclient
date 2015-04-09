package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ bs bJK;
    private final /* synthetic */ PbPageReadLocalResponseMessage bJL;
    private final /* synthetic */ com.baidu.tieba.pb.a.b bJM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.bJK = bsVar;
        this.bJL = pbPageReadLocalResponseMessage;
        this.bJM = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        bv bvVar;
        br brVar2;
        bv bvVar2;
        brVar = this.bJK.bJJ;
        bvVar = brVar.bJC;
        bvVar.a(true, 0, this.bJL.getUpdateType(), 0, this.bJM, this.bJL.getErrorString(), 0);
        brVar2 = this.bJK.bJJ;
        bvVar2 = brVar2.bJC;
        bvVar2.dG(false);
    }
}
