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
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
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
            aVar = this.cgV.cbH;
            if (aVar != null) {
                aVar4 = this.cgV.cbH;
                aVar4.ab(z2);
            }
            aVar2 = this.cgV.cbH;
            MarkData qr = aVar2.qr();
            am amVar = new am();
            amVar.setType(2);
            if (z2) {
                amVar.setData(qr);
                aVar3 = this.cgV.cbH;
                if (aVar3 != null) {
                    if (qr != null) {
                        akVar3 = this.cgV.cgM;
                        akVar3.eN(true);
                        akVar4 = this.cgV.cgM;
                        akVar5 = this.cgV.cgM;
                        akVar4.jC(akVar5.By());
                        this.cgV.showToast(MessageFormat.format(this.cgV.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qr.getFloor())));
                    } else {
                        this.cgV.showToast(this.cgV.getPageContext().getString(i.h.add_mark));
                    }
                }
            } else {
                amVar.setData(null);
                akVar = this.cgV.cgM;
                akVar.eN(false);
                akVar2 = this.cgV.cgM;
                akVar2.jC(null);
                this.cgV.showToast(this.cgV.getPageContext().getString(i.h.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            return;
        }
        this.cgV.showToast(this.cgV.getPageContext().getString(i.h.update_mark_failed));
    }
}
