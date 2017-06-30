package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0035a {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0035a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        ao aoVar;
        ao aoVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ao aoVar3;
        ao aoVar4;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.eHC.dPW;
            if (aVar != null) {
                aVar4 = this.eHC.dPW;
                aVar4.ac(z2);
            }
            aVar2 = this.eHC.dPW;
            MarkData nC = aVar2.nC();
            com.baidu.tieba.pb.h hVar = new com.baidu.tieba.pb.h();
            hVar.setType(2);
            if (z2) {
                hVar.setData(nC);
                aVar3 = this.eHC.dPW;
                if (aVar3 != null) {
                    if (nC != null) {
                        subPbModel3 = this.eHC.eHl;
                        subPbModel3.je(true);
                        subPbModel4 = this.eHC.eHl;
                        subPbModel5 = this.eHC.eHl;
                        subPbModel4.pg(subPbModel5.Db());
                        this.eHC.showToast(w.l.add_mark_on_pb);
                    } else {
                        this.eHC.showToast(this.eHC.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.eHC.eHn;
                    if (aoVar3 != null) {
                        aoVar4 = this.eHC.eHn;
                        aoVar4.jD(true);
                    }
                }
            } else {
                hVar.setData(null);
                subPbModel = this.eHC.eHl;
                subPbModel.je(false);
                subPbModel2 = this.eHC.eHl;
                subPbModel2.pg(null);
                this.eHC.showToast(this.eHC.getPageContext().getString(w.l.remove_mark));
                aoVar = this.eHC.eHn;
                if (aoVar != null) {
                    aoVar2 = this.eHC.eHn;
                    aoVar2.jD(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, hVar));
            return;
        }
        this.eHC.showToast(this.eHC.getPageContext().getString(w.l.update_mark_failed));
    }
}
