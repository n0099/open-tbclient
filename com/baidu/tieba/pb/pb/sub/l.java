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
public class l implements a.InterfaceC0032a {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        bc bcVar;
        bc bcVar2;
        ao aoVar;
        ao aoVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ao aoVar3;
        ao aoVar4;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.eis.dxb;
            if (aVar != null) {
                aVar4 = this.eis.dxb;
                aVar4.ad(z2);
            }
            aVar2 = this.eis.dxb;
            MarkData nC = aVar2.nC();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(nC);
                aVar3 = this.eis.dxb;
                if (aVar3 != null) {
                    if (nC != null) {
                        bcVar3 = this.eis.eib;
                        bcVar3.iA(true);
                        bcVar4 = this.eis.eib;
                        bcVar5 = this.eis.eib;
                        bcVar4.op(bcVar5.CX());
                        this.eis.showToast(MessageFormat.format(this.eis.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(nC.getFloor())));
                    } else {
                        this.eis.showToast(this.eis.getPageContext().getString(r.j.add_mark));
                    }
                    aoVar3 = this.eis.eid;
                    if (aoVar3 != null) {
                        aoVar4 = this.eis.eid;
                        aoVar4.iR(true);
                    }
                }
            } else {
                dVar.setData(null);
                bcVar = this.eis.eib;
                bcVar.iA(false);
                bcVar2 = this.eis.eib;
                bcVar2.op(null);
                this.eis.showToast(this.eis.getPageContext().getString(r.j.remove_mark));
                aoVar = this.eis.eid;
                if (aoVar != null) {
                    aoVar2 = this.eis.eid;
                    aoVar2.iR(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.eis.showToast(this.eis.getPageContext().getString(r.j.update_mark_failed));
    }
}
