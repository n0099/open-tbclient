package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0032a {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        aw awVar;
        aw awVar2;
        af afVar;
        af afVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        af afVar3;
        af afVar4;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.dWP.dvH;
            if (aVar != null) {
                aVar4 = this.dWP.dvH;
                aVar4.Z(z2);
            }
            aVar2 = this.dWP.dvH;
            MarkData mN = aVar2.mN();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(mN);
                aVar3 = this.dWP.dvH;
                if (aVar3 != null) {
                    if (mN != null) {
                        awVar3 = this.dWP.dWC;
                        awVar3.hG(true);
                        awVar4 = this.dWP.dWC;
                        awVar5 = this.dWP.dWC;
                        awVar4.nO(awVar5.BL());
                        this.dWP.showToast(MessageFormat.format(this.dWP.getPageContext().getString(u.j.add_mark_on_pb), Integer.valueOf(mN.getFloor())));
                    } else {
                        this.dWP.showToast(this.dWP.getPageContext().getString(u.j.add_mark));
                    }
                    afVar3 = this.dWP.dWE;
                    if (afVar3 != null) {
                        afVar4 = this.dWP.dWE;
                        afVar4.hY(true);
                    }
                }
            } else {
                eVar.setData(null);
                awVar = this.dWP.dWC;
                awVar.hG(false);
                awVar2 = this.dWP.dWC;
                awVar2.nO(null);
                this.dWP.showToast(this.dWP.getPageContext().getString(u.j.remove_mark));
                afVar = this.dWP.dWE;
                if (afVar != null) {
                    afVar2 = this.dWP.dWE;
                    afVar2.hY(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.dWP.showToast(this.dWP.getPageContext().getString(u.j.update_mark_failed));
    }
}
