package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0040a {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0040a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ao aoVar;
        ao aoVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.cLc.cFm;
            if (aVar != null) {
                aVar4 = this.cLc.cFm;
                aVar4.Y(z2);
            }
            aVar2 = this.cLc.cFm;
            MarkData pQ = aVar2.pQ();
            aq aqVar = new aq();
            aqVar.setType(2);
            if (z2) {
                aqVar.setData(pQ);
                aVar3 = this.cLc.cFm;
                if (aVar3 != null) {
                    if (pQ != null) {
                        aoVar3 = this.cLc.cKR;
                        aoVar3.fy(true);
                        aoVar4 = this.cLc.cKR;
                        aoVar5 = this.cLc.cKR;
                        aoVar4.kP(aoVar5.BJ());
                        this.cLc.showToast(MessageFormat.format(this.cLc.getPageContext().getString(n.j.add_mark_on_pb), Integer.valueOf(pQ.getFloor())));
                    } else {
                        this.cLc.showToast(this.cLc.getPageContext().getString(n.j.add_mark));
                    }
                }
            } else {
                aqVar.setData(null);
                aoVar = this.cLc.cKR;
                aoVar.fy(false);
                aoVar2 = this.cLc.cKR;
                aoVar2.kP(null);
                this.cLc.showToast(this.cLc.getPageContext().getString(n.j.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aqVar));
            return;
        }
        this.cLc.showToast(this.cLc.getPageContext().getString(n.j.update_mark_failed));
    }
}
