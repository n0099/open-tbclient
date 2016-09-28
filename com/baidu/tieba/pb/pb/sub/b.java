package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ax.a {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ax.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar) {
        ag agVar;
        ag agVar2;
        ax axVar;
        ag agVar3;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        ag agVar4;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ag agVar5;
        agVar = this.exF.exu;
        if (agVar != null) {
            agVar5 = this.exF.exu;
            agVar5.aRb();
        }
        if (z) {
            agVar2 = this.exF.exu;
            agVar2.hideNoDataView();
            if (nVar != null) {
                if (nVar.aMN() == null) {
                    axVar4 = this.exF.exr;
                }
                com.baidu.tieba.tbadkCore.data.q aMN = nVar.aMN();
                axVar = this.exF.exr;
                aMN.a(axVar.aRG());
                agVar3 = this.exF.exu;
                if (agVar3 != null) {
                    agVar4 = this.exF.exu;
                    axVar2 = this.exF.exr;
                    int aMz = axVar2.aMz();
                    axVar3 = this.exF.exr;
                    agVar4.a(nVar, aMz, axVar3.aRI() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(nVar);
                pVar = this.exF.duz;
                if (pVar != null) {
                    pVar2 = this.exF.duz;
                    pVar2.a(nVar.getAntiData());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.exF.showToast(str);
        this.exF.M(i, str);
    }
}
