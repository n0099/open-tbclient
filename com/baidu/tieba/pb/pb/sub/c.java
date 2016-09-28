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
public class c implements a.InterfaceC0032a {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ax axVar;
        ax axVar2;
        ag agVar;
        ag agVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ag agVar3;
        ag agVar4;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.exF.dMU;
            if (aVar != null) {
                aVar4 = this.exF.dMU;
                aVar4.ad(z2);
            }
            aVar2 = this.exF.dMU;
            MarkData ny = aVar2.ny();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(ny);
                aVar3 = this.exF.dMU;
                if (aVar3 != null) {
                    if (ny != null) {
                        axVar3 = this.exF.exr;
                        axVar3.iq(true);
                        axVar4 = this.exF.exr;
                        axVar5 = this.exF.exr;
                        axVar4.pB(axVar5.Dg());
                        this.exF.showToast(MessageFormat.format(this.exF.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(ny.getFloor())));
                    } else {
                        this.exF.showToast(this.exF.getPageContext().getString(r.j.add_mark));
                    }
                    agVar3 = this.exF.exu;
                    if (agVar3 != null) {
                        agVar4 = this.exF.exu;
                        agVar4.iI(true);
                    }
                }
            } else {
                eVar.setData(null);
                axVar = this.exF.exr;
                axVar.iq(false);
                axVar2 = this.exF.exr;
                axVar2.pB(null);
                this.exF.showToast(this.exF.getPageContext().getString(r.j.remove_mark));
                agVar = this.exF.exu;
                if (agVar != null) {
                    agVar2 = this.exF.exu;
                    agVar2.iI(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.exF.showToast(this.exF.getPageContext().getString(r.j.update_mark_failed));
    }
}
