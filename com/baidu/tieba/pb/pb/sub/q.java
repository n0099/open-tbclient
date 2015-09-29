package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.InterfaceC0039a {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0039a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ak akVar;
        ak akVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.cmr.chW;
            if (aVar != null) {
                aVar4 = this.cmr.chW;
                aVar4.ab(z2);
            }
            aVar2 = this.cmr.chW;
            MarkData qn = aVar2.qn();
            am amVar = new am();
            amVar.setType(2);
            if (z2) {
                amVar.setData(qn);
                aVar3 = this.cmr.chW;
                if (aVar3 != null) {
                    if (qn != null) {
                        akVar3 = this.cmr.cmi;
                        akVar3.eS(true);
                        akVar4 = this.cmr.cmi;
                        akVar5 = this.cmr.cmi;
                        akVar4.jX(akVar5.Bl());
                        this.cmr.showToast(MessageFormat.format(this.cmr.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qn.getFloor())));
                    } else {
                        this.cmr.showToast(this.cmr.getPageContext().getString(i.h.add_mark));
                    }
                }
            } else {
                amVar.setData(null);
                akVar = this.cmr.cmi;
                akVar.eS(false);
                akVar2 = this.cmr.cmi;
                akVar2.jX(null);
                this.cmr.showToast(this.cmr.getPageContext().getString(i.h.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            return;
        }
        this.cmr.showToast(this.cmr.getPageContext().getString(i.h.update_mark_failed));
    }
}
