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
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
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
            aVar = this.cmC.cii;
            if (aVar != null) {
                aVar4 = this.cmC.cii;
                aVar4.ab(z2);
            }
            aVar2 = this.cmC.cii;
            MarkData qk = aVar2.qk();
            am amVar = new am();
            amVar.setType(2);
            if (z2) {
                amVar.setData(qk);
                aVar3 = this.cmC.cii;
                if (aVar3 != null) {
                    if (qk != null) {
                        akVar3 = this.cmC.cmt;
                        akVar3.eS(true);
                        akVar4 = this.cmC.cmt;
                        akVar5 = this.cmC.cmt;
                        akVar4.jX(akVar5.Bi());
                        this.cmC.showToast(MessageFormat.format(this.cmC.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qk.getFloor())));
                    } else {
                        this.cmC.showToast(this.cmC.getPageContext().getString(i.h.add_mark));
                    }
                }
            } else {
                amVar.setData(null);
                akVar = this.cmC.cmt;
                akVar.eS(false);
                akVar2 = this.cmC.cmt;
                akVar2.jX(null);
                this.cmC.showToast(this.cmC.getPageContext().getString(i.h.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            return;
        }
        this.cmC.showToast(this.cmC.getPageContext().getString(i.h.update_mark_failed));
    }
}
