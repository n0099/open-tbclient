package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ap.a {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ap.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.data.g gVar) {
        x xVar;
        x xVar2;
        ap apVar;
        x xVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        x xVar4;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        x xVar5;
        xVar = this.doF.dow;
        if (xVar != null) {
            xVar5 = this.doF.dow;
            xVar5.azS();
        }
        if (z) {
            xVar2 = this.doF.dow;
            xVar2.hideNoDataView();
            if (gVar != null) {
                if (gVar.avI() == null) {
                    apVar4 = this.doF.dou;
                }
                com.baidu.tieba.tbadkCore.data.s avI = gVar.avI();
                apVar = this.doF.dou;
                avI.a(apVar.aAu());
                xVar3 = this.doF.dow;
                if (xVar3 != null) {
                    xVar4 = this.doF.dow;
                    apVar2 = this.doF.dou;
                    int avB = apVar2.avB();
                    apVar3 = this.doF.dou;
                    xVar4.a(gVar, avB, apVar3.aAw() != null);
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(gVar);
                pVar = this.doF.cye;
                if (pVar != null) {
                    pVar2 = this.doF.cye;
                    pVar2.a(gVar.amu());
                }
                fVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
                return;
            }
            return;
        }
        this.doF.showToast(str);
        this.doF.K(i, str);
    }
}
