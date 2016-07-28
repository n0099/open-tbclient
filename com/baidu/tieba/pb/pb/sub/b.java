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
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
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
            aVar = this.ejr.dzj;
            if (aVar != null) {
                aVar4 = this.ejr.dzj;
                aVar4.ab(z2);
            }
            aVar2 = this.ejr.dzj;
            MarkData mD = aVar2.mD();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(mD);
                aVar3 = this.ejr.dzj;
                if (aVar3 != null) {
                    if (mD != null) {
                        awVar3 = this.ejr.eje;
                        awVar3.hS(true);
                        awVar4 = this.ejr.eje;
                        awVar5 = this.ejr.eje;
                        awVar4.oB(awVar5.BL());
                        this.ejr.showToast(MessageFormat.format(this.ejr.getPageContext().getString(u.j.add_mark_on_pb), Integer.valueOf(mD.getFloor())));
                    } else {
                        this.ejr.showToast(this.ejr.getPageContext().getString(u.j.add_mark));
                    }
                    afVar3 = this.ejr.ejg;
                    if (afVar3 != null) {
                        afVar4 = this.ejr.ejg;
                        afVar4.ik(true);
                    }
                }
            } else {
                eVar.setData(null);
                awVar = this.ejr.eje;
                awVar.hS(false);
                awVar2 = this.ejr.eje;
                awVar2.oB(null);
                this.ejr.showToast(this.ejr.getPageContext().getString(u.j.remove_mark));
                afVar = this.ejr.ejg;
                if (afVar != null) {
                    afVar2 = this.ejr.ejg;
                    afVar2.ik(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.ejr.showToast(this.ejr.getPageContext().getString(u.j.update_mark_failed));
    }
}
