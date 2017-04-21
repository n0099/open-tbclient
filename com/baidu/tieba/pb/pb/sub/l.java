package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0028a {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0028a
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
            aVar = this.evm.dHE;
            if (aVar != null) {
                aVar4 = this.evm.dHE;
                aVar4.ae(z2);
            }
            aVar2 = this.evm.dHE;
            MarkData oh = aVar2.oh();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(oh);
                aVar3 = this.evm.dHE;
                if (aVar3 != null) {
                    if (oh != null) {
                        subPbModel3 = this.evm.euV;
                        subPbModel3.iO(true);
                        subPbModel4 = this.evm.euV;
                        subPbModel5 = this.evm.euV;
                        subPbModel4.nS(subPbModel5.DJ());
                        this.evm.showToast(MessageFormat.format(this.evm.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(oh.getFloor())));
                    } else {
                        this.evm.showToast(this.evm.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.evm.euX;
                    if (aoVar3 != null) {
                        aoVar4 = this.evm.euX;
                        aoVar4.ji(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.evm.euV;
                subPbModel.iO(false);
                subPbModel2 = this.evm.euV;
                subPbModel2.nS(null);
                this.evm.showToast(this.evm.getPageContext().getString(w.l.remove_mark));
                aoVar = this.evm.euX;
                if (aoVar != null) {
                    aoVar2 = this.evm.euX;
                    aoVar2.ji(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.evm.showToast(this.evm.getPageContext().getString(w.l.update_mark_failed));
    }
}
