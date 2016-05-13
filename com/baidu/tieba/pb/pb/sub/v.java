package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ap.a {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ap.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.h hVar) {
        y yVar;
        y yVar2;
        ap apVar;
        y yVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        y yVar4;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        y yVar5;
        yVar = this.dqn.dqe;
        if (yVar != null) {
            yVar5 = this.dqn.dqe;
            yVar5.aAc();
        }
        if (z) {
            yVar2 = this.dqn.dqe;
            yVar2.hideNoDataView();
            if (hVar != null) {
                if (hVar.avR() == null) {
                    apVar4 = this.dqn.dqc;
                }
                com.baidu.tieba.tbadkCore.data.s avR = hVar.avR();
                apVar = this.dqn.dqc;
                avR.a(apVar.aAF());
                yVar3 = this.dqn.dqe;
                if (yVar3 != null) {
                    yVar4 = this.dqn.dqe;
                    apVar2 = this.dqn.dqc;
                    int avK = apVar2.avK();
                    apVar3 = this.dqn.dqc;
                    yVar4.a(hVar, avK, apVar3.aAH() != null);
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(hVar);
                pVar = this.dqn.czd;
                if (pVar != null) {
                    pVar2 = this.dqn.czd;
                    pVar2.a(hVar.getAntiData());
                }
                fVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
                return;
            }
            return;
        }
        this.dqn.showToast(str);
        this.dqn.I(i, str);
    }
}
