package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements Runnable {
    final /* synthetic */ cn cPe;
    private final /* synthetic */ PbPageReadLocalResponseMessage cPf;
    private final /* synthetic */ com.baidu.tieba.pb.a.c cPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage, com.baidu.tieba.pb.a.c cVar) {
        this.cPe = cnVar;
        this.cPf = pbPageReadLocalResponseMessage;
        this.cPg = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar;
        cm.c cVar;
        cm cmVar2;
        cm.c cVar2;
        cmVar = this.cPe.cPd;
        cVar = cmVar.cOL;
        cVar.a(true, 0, this.cPf.getUpdateType(), 0, this.cPg, this.cPf.getErrorString(), 0);
        cmVar2 = this.cPe.cPd;
        cVar2 = cmVar2.cOL;
        cVar2.fo(false);
    }
}
