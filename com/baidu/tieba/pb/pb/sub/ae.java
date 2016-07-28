package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements aw.a {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
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
        afVar = this.ejr.ejg;
        if (afVar != null) {
            afVar5 = this.ejr.ejg;
            afVar5.aLD();
        }
        if (z) {
            afVar2 = this.ejr.ejg;
            afVar2.hideNoDataView();
            if (mVar != null) {
                if (mVar.aHp() == null) {
                    awVar4 = this.ejr.eje;
                }
                com.baidu.tieba.tbadkCore.data.s aHp = mVar.aHp();
                awVar = this.ejr.eje;
                aHp.a(awVar.aMg());
                afVar3 = this.ejr.ejg;
                if (afVar3 != null) {
                    afVar4 = this.ejr.ejg;
                    awVar2 = this.ejr.eje;
                    int aHf = awVar2.aHf();
                    awVar3 = this.ejr.eje;
                    afVar4.a(mVar, aHf, awVar3.aMi() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(mVar);
                pVar = this.ejr.dhw;
                if (pVar != null) {
                    pVar2 = this.ejr.dhw;
                    pVar2.a(mVar.getAntiData());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.ejr.showToast(str);
        this.ejr.L(i, str);
    }
}
