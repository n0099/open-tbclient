package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ br bJv;
    private final /* synthetic */ PbPageReadLocalResponseMessage bJw;
    private final /* synthetic */ com.baidu.tieba.pb.a.b bJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.b bVar) {
        this.bJv = brVar;
        this.bJw = pbPageReadLocalResponseMessage;
        this.bJx = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bu buVar;
        bq bqVar2;
        bu buVar2;
        bqVar = this.bJv.bJu;
        buVar = bqVar.bJn;
        buVar.a(true, 0, this.bJw.getUpdateType(), 0, this.bJx, this.bJw.getErrorString(), 0);
        bqVar2 = this.bJv.bJu;
        buVar2 = bqVar2.bJn;
        buVar2.dI(false);
    }
}
