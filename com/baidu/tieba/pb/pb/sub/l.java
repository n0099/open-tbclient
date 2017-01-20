package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0031a {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0031a
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
            aVar = this.erC.dGi;
            if (aVar != null) {
                aVar4 = this.erC.dGi;
                aVar4.ad(z2);
            }
            aVar2 = this.erC.dGi;
            MarkData nw = aVar2.nw();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(nw);
                aVar3 = this.erC.dGi;
                if (aVar3 != null) {
                    if (nw != null) {
                        subPbModel3 = this.erC.erl;
                        subPbModel3.iK(true);
                        subPbModel4 = this.erC.erl;
                        subPbModel5 = this.erC.erl;
                        subPbModel4.oF(subPbModel5.CS());
                        this.erC.showToast(MessageFormat.format(this.erC.getPageContext().getString(r.l.add_mark_on_pb), Integer.valueOf(nw.getFloor())));
                    } else {
                        this.erC.showToast(this.erC.getPageContext().getString(r.l.add_mark));
                    }
                    aoVar3 = this.erC.ern;
                    if (aoVar3 != null) {
                        aoVar4 = this.erC.ern;
                        aoVar4.jd(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.erC.erl;
                subPbModel.iK(false);
                subPbModel2 = this.erC.erl;
                subPbModel2.oF(null);
                this.erC.showToast(this.erC.getPageContext().getString(r.l.remove_mark));
                aoVar = this.erC.ern;
                if (aoVar != null) {
                    aoVar2 = this.erC.ern;
                    aoVar2.jd(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.erC.showToast(this.erC.getPageContext().getString(r.l.update_mark_failed));
    }
}
