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
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
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
            aVar = this.cfY.caM;
            if (aVar != null) {
                aVar4 = this.cfY.caM;
                aVar4.ab(z2);
            }
            aVar2 = this.cfY.caM;
            MarkData qu = aVar2.qu();
            am amVar = new am();
            amVar.setType(2);
            if (z2) {
                amVar.setData(qu);
                aVar3 = this.cfY.caM;
                if (aVar3 != null) {
                    if (qu != null) {
                        akVar3 = this.cfY.cfP;
                        akVar3.eF(true);
                        akVar4 = this.cfY.cfP;
                        akVar5 = this.cfY.cfP;
                        akVar4.ju(akVar5.Bl());
                        this.cfY.showToast(MessageFormat.format(this.cfY.getPageContext().getString(i.C0057i.add_mark_on_pb), Integer.valueOf(qu.getFloor())));
                    } else {
                        this.cfY.showToast(this.cfY.getPageContext().getString(i.C0057i.add_mark));
                    }
                }
            } else {
                amVar.setData(null);
                akVar = this.cfY.cfP;
                akVar.eF(false);
                akVar2 = this.cfY.cfP;
                akVar2.ju(null);
                this.cfY.showToast(this.cfY.getPageContext().getString(i.C0057i.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, amVar));
            return;
        }
        this.cfY.showToast(this.cfY.getPageContext().getString(i.C0057i.update_mark_failed));
    }
}
