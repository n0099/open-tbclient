package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aw.a {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
     */
    @Override // com.baidu.tieba.pb.pb.sub.aw.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.m mVar) {
        af afVar;
        af afVar2;
        aw awVar;
        af afVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        af afVar4;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        af afVar5;
        afVar = this.dWP.dWE;
        if (afVar != null) {
            afVar5 = this.dWP.dWE;
            afVar5.aIs();
        }
        if (z) {
            afVar2 = this.dWP.dWE;
            afVar2.hideNoDataView();
            if (mVar != null) {
                if (mVar.aEe() == null) {
                    awVar4 = this.dWP.dWC;
                }
                com.baidu.tieba.tbadkCore.data.s aEe = mVar.aEe();
                awVar = this.dWP.dWC;
                aEe.a(awVar.aIV());
                afVar3 = this.dWP.dWE;
                if (afVar3 != null) {
                    afVar4 = this.dWP.dWE;
                    awVar2 = this.dWP.dWC;
                    int aDU = awVar2.aDU();
                    awVar3 = this.dWP.dWC;
                    afVar4.a(mVar, aDU, awVar3.aIX() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(mVar);
                pVar = this.dWP.deA;
                if (pVar != null) {
                    pVar2 = this.dWP.deA;
                    pVar2.a(mVar.getAntiData());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.dWP.showToast(str);
        this.dWP.M(i, str);
    }
}
