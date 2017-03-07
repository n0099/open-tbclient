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
public class l implements a.InterfaceC0030a {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0030a
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
            aVar = this.euQ.dIP;
            if (aVar != null) {
                aVar4 = this.euQ.dIP;
                aVar4.ac(z2);
            }
            aVar2 = this.euQ.dIP;
            MarkData nK = aVar2.nK();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(nK);
                aVar3 = this.euQ.dIP;
                if (aVar3 != null) {
                    if (nK != null) {
                        subPbModel3 = this.euQ.euz;
                        subPbModel3.iF(true);
                        subPbModel4 = this.euQ.euz;
                        subPbModel5 = this.euQ.euz;
                        subPbModel4.nN(subPbModel5.Dl());
                        this.euQ.showToast(MessageFormat.format(this.euQ.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(nK.getFloor())));
                    } else {
                        this.euQ.showToast(this.euQ.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.euQ.euB;
                    if (aoVar3 != null) {
                        aoVar4 = this.euQ.euB;
                        aoVar4.iZ(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.euQ.euz;
                subPbModel.iF(false);
                subPbModel2 = this.euQ.euz;
                subPbModel2.nN(null);
                this.euQ.showToast(this.euQ.getPageContext().getString(w.l.remove_mark));
                aoVar = this.euQ.euB;
                if (aoVar != null) {
                    aoVar2 = this.euQ.euB;
                    aoVar2.iZ(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.euQ.showToast(this.euQ.getPageContext().getString(w.l.update_mark_failed));
    }
}
