package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ao.a {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r0 != null) goto L22;
     */
    @Override // com.baidu.tieba.pb.pb.sub.ao.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, String str, com.baidu.tieba.pb.a.d dVar) {
        w wVar;
        w wVar2;
        ao aoVar;
        w wVar3;
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        w wVar4;
        ao aoVar2;
        ao aoVar3;
        w wVar5;
        wVar = this.cLc.cKT;
        if (wVar != null) {
            wVar5 = this.cLc.cKT;
            wVar5.anE();
        }
        if (z) {
            wVar2 = this.cLc.cKT;
            wVar2.hideNoDataView();
            if (dVar != null) {
                if (dVar.akS() == null) {
                    aoVar3 = this.cLc.cKR;
                }
                com.baidu.tieba.tbadkCore.data.r akS = dVar.akS();
                aoVar = this.cLc.cKR;
                akS.a(aoVar.aoe());
                wVar3 = this.cLc.cKT;
                if (wVar3 != null) {
                    wVar4 = this.cLc.cKT;
                    aoVar2 = this.cLc.cKR;
                    wVar4.a(dVar, aoVar2.akL());
                }
                aq aqVar = new aq();
                aqVar.setData(dVar);
                pVar = this.cLc.cjc;
                if (pVar != null) {
                    pVar2 = this.cLc.cjc;
                    pVar2.a(dVar.ala());
                }
                aqVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aqVar));
                return;
            }
            return;
        }
        this.cLc.showToast(str);
        this.cLc.M(i, str);
    }
}
