package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0033a {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0033a
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
            aVar = this.eqU.dCb;
            if (aVar != null) {
                aVar4 = this.eqU.dCb;
                aVar4.ad(z2);
            }
            aVar2 = this.eqU.dCb;
            MarkData nO = aVar2.nO();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(nO);
                aVar3 = this.eqU.dCb;
                if (aVar3 != null) {
                    if (nO != null) {
                        subPbModel3 = this.eqU.eqD;
                        subPbModel3.is(true);
                        subPbModel4 = this.eqU.eqD;
                        subPbModel5 = this.eqU.eqD;
                        subPbModel4.nY(subPbModel5.CN());
                        this.eqU.showToast(w.l.add_mark_on_pb);
                    } else {
                        this.eqU.showToast(this.eqU.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.eqU.eqF;
                    if (aoVar3 != null) {
                        aoVar4 = this.eqU.eqF;
                        aoVar4.iN(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.eqU.eqD;
                subPbModel.is(false);
                subPbModel2 = this.eqU.eqD;
                subPbModel2.nY(null);
                this.eqU.showToast(this.eqU.getPageContext().getString(w.l.remove_mark));
                aoVar = this.eqU.eqF;
                if (aoVar != null) {
                    aoVar2 = this.eqU.eqF;
                    aoVar2.iN(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.eqU.showToast(this.eqU.getPageContext().getString(w.l.update_mark_failed));
    }
}
