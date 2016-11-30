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
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
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
            aVar = this.eEs.dSz;
            if (aVar != null) {
                aVar4 = this.eEs.dSz;
                aVar4.ad(z2);
            }
            aVar2 = this.eEs.dSz;
            MarkData nC = aVar2.nC();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(nC);
                aVar3 = this.eEs.dSz;
                if (aVar3 != null) {
                    if (nC != null) {
                        bcVar3 = this.eEs.eEb;
                        bcVar3.iO(true);
                        bcVar4 = this.eEs.eEb;
                        bcVar5 = this.eEs.eEb;
                        bcVar4.pO(bcVar5.Do());
                        this.eEs.showToast(MessageFormat.format(this.eEs.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(nC.getFloor())));
                    } else {
                        this.eEs.showToast(this.eEs.getPageContext().getString(r.j.add_mark));
                    }
                    aoVar3 = this.eEs.eEd;
                    if (aoVar3 != null) {
                        aoVar4 = this.eEs.eEd;
                        aoVar4.jg(true);
                    }
                }
            } else {
                eVar.setData(null);
                bcVar = this.eEs.eEb;
                bcVar.iO(false);
                bcVar2 = this.eEs.eEb;
                bcVar2.pO(null);
                this.eEs.showToast(this.eEs.getPageContext().getString(r.j.remove_mark));
                aoVar = this.eEs.eEd;
                if (aoVar != null) {
                    aoVar2 = this.eEs.eEd;
                    aoVar2.jg(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.eEs.showToast(this.eEs.getPageContext().getString(r.j.update_mark_failed));
    }
}
