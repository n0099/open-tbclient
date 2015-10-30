package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ak.a {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L22;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ak.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar) {
        t tVar;
        t tVar2;
        ak akVar;
        t tVar3;
        com.baidu.tbadk.editortools.c.n nVar;
        com.baidu.tbadk.editortools.c.n nVar2;
        t tVar4;
        ak akVar2;
        ak akVar3;
        t tVar5;
        tVar = this.cmC.cmv;
        if (tVar != null) {
            tVar5 = this.cmC.cmv;
            tVar5.ahj();
        }
        if (z) {
            tVar2 = this.cmC.cmv;
            tVar2.hideNoDataView();
            if (cVar != null) {
                if (cVar.aeV() == null) {
                    akVar3 = this.cmC.cmt;
                }
                com.baidu.tieba.tbadkCore.data.k aeV = cVar.aeV();
                akVar = this.cmC.cmt;
                aeV.a(akVar.ahK());
                tVar3 = this.cmC.cmv;
                if (tVar3 != null) {
                    tVar4 = this.cmC.cmv;
                    akVar2 = this.cmC.cmt;
                    tVar4.a(cVar, akVar2.aeO());
                }
                am amVar = new am();
                amVar.setData(cVar);
                nVar = this.cmC.caU;
                if (nVar != null) {
                    nVar2 = this.cmC.caU;
                    nVar2.a(cVar.afd());
                }
                amVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
                return;
            }
            return;
        }
        this.cmC.showToast(str);
        this.cmC.K(i, str);
    }
}
