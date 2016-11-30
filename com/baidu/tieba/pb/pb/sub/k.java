package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.bc;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bc.a {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0 != null) goto L33;
     */
    @Override // com.baidu.tieba.pb.pb.sub.bc.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar) {
        ao aoVar;
        b bVar;
        ao aoVar2;
        bc bcVar;
        ao aoVar3;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        ao aoVar4;
        bc bcVar2;
        bc bcVar3;
        boolean z2;
        bc bcVar4;
        b bVar2;
        b bVar3;
        ao aoVar5;
        aoVar = this.eEs.eEd;
        if (aoVar != null) {
            aoVar5 = this.eEs.eEd;
            aoVar5.aTo();
        }
        bVar = this.eEs.eEp;
        if (bVar != null) {
            bVar2 = this.eEs.eEp;
            if (bVar2.aSX()) {
                bVar3 = this.eEs.eEp;
                bVar3.oP(r.d.cp_bg_line_k_alpha40);
            }
        }
        if (z) {
            aoVar2 = this.eEs.eEd;
            aoVar2.hideNoDataView();
            if (nVar != null) {
                if (nVar.aOG() == null) {
                    bcVar4 = this.eEs.eEb;
                }
                com.baidu.tieba.tbadkCore.data.q aOG = nVar.aOG();
                bcVar = this.eEs.eEb;
                aOG.a(bcVar.aTO());
                aoVar3 = this.eEs.eEd;
                if (aoVar3 != null) {
                    aoVar4 = this.eEs.eEd;
                    bcVar2 = this.eEs.eEb;
                    int aOt = bcVar2.aOt();
                    bcVar3 = this.eEs.eEb;
                    aoVar4.a(nVar, aOt, bcVar3.aTQ() != null);
                    z2 = this.eEs.eEm;
                    if (z2) {
                        this.eEs.aTc();
                        this.eEs.eEm = false;
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(nVar);
                pVar = this.eEs.dAe;
                if (pVar != null) {
                    pVar2 = this.eEs.dAe;
                    pVar2.a(nVar.getAntiData());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.eEs.M(i, str);
    }
}
