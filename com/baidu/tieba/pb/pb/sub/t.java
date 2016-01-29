package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ao.a {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 != null) goto L26;
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
        ao aoVar4;
        w wVar5;
        wVar = this.cTK.cTB;
        if (wVar != null) {
            wVar5 = this.cTK.cTB;
            wVar5.ash();
        }
        if (z) {
            wVar2 = this.cTK.cTB;
            wVar2.hideNoDataView();
            if (dVar != null) {
                if (dVar.aoQ() == null) {
                    aoVar4 = this.cTK.cTz;
                }
                com.baidu.tieba.tbadkCore.data.r aoQ = dVar.aoQ();
                aoVar = this.cTK.cTz;
                aoQ.a(aoVar.asK());
                wVar3 = this.cTK.cTB;
                if (wVar3 != null) {
                    wVar4 = this.cTK.cTB;
                    aoVar2 = this.cTK.cTz;
                    int aoJ = aoVar2.aoJ();
                    aoVar3 = this.cTK.cTz;
                    wVar4.a(dVar, aoJ, aoVar3.asM() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(dVar);
                pVar = this.cTK.cnC;
                if (pVar != null) {
                    pVar2 = this.cTK.cnC;
                    pVar2.a(dVar.ajb());
                }
                eVar.setType(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                return;
            }
            return;
        }
        this.cTK.showToast(str);
        this.cTK.O(i, str);
    }
}
