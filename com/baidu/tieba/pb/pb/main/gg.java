package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.view.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gg implements c.a {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.c.a
    public void i(com.baidu.tieba.tbadkCore.data.q qVar) {
        com.baidu.tieba.pb.pb.main.view.c cVar;
        ck ckVar;
        cz czVar;
        cVar = this.eCT.ewJ;
        cVar.j(qVar);
        ckVar = this.eCT.eBj;
        ckVar.notifyDataSetChanged();
        czVar = this.eCT.eCn;
        czVar.aPU();
    }
}
